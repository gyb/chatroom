package chat.server.handler;

import io.netty.channel.Channel;
import chat.message.ChatMessage;
import chat.server.MessageHandler;

public class UnknownTypeHandler implements MessageHandler {

	@Override
	public void handle(Channel channel, ChatMessage message) {
		// TODO Auto-generated method stub

	}

}
