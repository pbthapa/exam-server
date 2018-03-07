package com.lis.exam.config;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SocketHandler extends TextWebSocketHandler {
	 List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

	 /**
	  * Current information is to broadcast information to all connected sessions
	  */
		@Override
		public void handleTextMessage(WebSocketSession session, TextMessage message)
				throws InterruptedException, IOException {
			/**
			 *  broadcast to all connected session
			 */
//			for(WebSocketSession webSocketSession : sessions) {
//				Map value = new Gson().fromJson(message.getPayload(), Map.class);
//				webSocketSession.sendMessage(new TextMessage("Hello " + value.get("name") + " !"));
//			}
			System.out.println(session.getId());
			ObjectMapper mapper = new ObjectMapper();
			Map map = mapper.readValue(message.getPayload(), Map.class);
			System.out.println(map.get("to"));
			session.sendMessage(new TextMessage("Hello " + map.get("to") + " !"));
		}

		@Override
		public void afterConnectionEstablished(WebSocketSession session) throws Exception {
			//the messages will be broadcasted to all users.
			sessions.add(session);
		}

}
