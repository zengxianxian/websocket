package com.zxx.websocket.servlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new WebSocketHandler(), "/firstWS")
			.addInterceptors(new WebSocketHandShake());
	}
	
//	@Bean
//	public ServletServerContainerFactoryBean createWebSocketContainer(){
//		ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
//		return container;
//	}

}
