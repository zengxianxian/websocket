package com.zxx.websocket.filter;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class LogFilter implements Filter{
	Logger log = Logger.getLogger(LogFilter.class);
	@Override
	public void destroy() {
		if(log.isDebugEnabled()){
			log.info("log filter destory");
		}
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		Enumeration<String> parameterNames = arg0.getParameterNames();
		String url = ((HttpServletRequest)arg0).getServletPath();
		StringBuffer sb = new StringBuffer(url);
		sb.append(":{");
		while(parameterNames.hasMoreElements()){
			String temp = parameterNames.nextElement();
			sb.append(temp);
			sb.append(':');
			Object obj = arg0.getParameter(temp);
			sb.append(obj);
			sb.append(',');
		}
		sb.append('}');
		long begin = new Date().getTime();
		try{
			arg2.doFilter(arg0, arg1);
		}catch(Exception e){
			log.warn(e);
		}
		long end = new Date().getTime();
		log.info("["+(end - begin)+"]"+sb.toString());
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		if(log.isDebugEnabled()){
			log.info("log filter is initing");
		}
	}

}
