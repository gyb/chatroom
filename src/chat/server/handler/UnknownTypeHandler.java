package chat.server.handler;

import io.netty.channel.Channel;

import java.util.logging.Logger;

import chat.message.ChatMessage;
import chat.server.MessageHandler;

public class UnknownTypeHandler implements MessageHandler {
	private final static Logger logger = Logger.getLogger(UnknownTypeHandler.class.getName());

	@Override
	public void handle(Channel channel, ChatMessage message) {
		logger.warning("Unknown message type: " + message.getType());
	}

}
