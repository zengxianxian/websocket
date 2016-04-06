package com.zxx.websocket.servlet;


import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {
	private static final Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("handleTextMessage:"+message.getPayload());
		session.sendMessage(message);
	}
	
}
