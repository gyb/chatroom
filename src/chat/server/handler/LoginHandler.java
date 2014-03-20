package chat.server.handler;

import java.util.logging.Logger;

import io.netty.channel.Channel;
import chat.message.ChatMessage;
import chat.server.MessageHandler;
import chat.server.clients.ClientsManager;

public class LoginHandler implements MessageHandler {
	private final static Logger logger = Logger.getLogger(LoginHandler.class.getName());

	@Override
	public void handle(Channel channel, ChatMessage message) {
		String content = message.getContent();
		Integer userId = Integer.decode(content);
		ClientsManager.add(userId, channel);
		logger.info("User " + userId + " login!");
	}

}
