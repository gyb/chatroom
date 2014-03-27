package chat.server.handler;

import java.util.logging.Logger;

import io.netty.channel.Channel;
import chat.message.ChatMessage;
import chat.server.MessageHandler;

public class ConfirmHandler implements MessageHandler {
	private final static Logger logger = Logger.getLogger(LoginHandler.class.getName());

	@Override
	public void handle(Channel channel, ChatMessage message) {
		logger.info("Received confirmed message " + message.getId() + " from client " + channel);
		//TODO
	}

}
