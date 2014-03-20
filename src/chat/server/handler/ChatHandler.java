package chat.server.handler;

import java.util.logging.Logger;

import io.netty.channel.Channel;
import chat.message.ChatMessage;
import chat.server.MessageHandler;
import chat.server.clients.ClientsManager;

public class ChatHandler implements MessageHandler {
	private final static Logger logger = Logger.getLogger(ChatHandler.class.getName());

	@Override
	public void handle(Channel channel, ChatMessage message) {
		Channel savedChannel = ClientsManager.get(message.getSender());
		if (channel != savedChannel) {
			logger.warning("Received message but not login, skip it");
			return;
		}
		
		for (Channel clientChannel : ClientsManager.getChannels()) {
			if (channel == clientChannel) {
				continue;
			}
			clientChannel.write(message);
		}
	}

}
