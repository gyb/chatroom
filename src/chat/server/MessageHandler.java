package chat.server;

import io.netty.channel.Channel;
import chat.message.ChatMessage;

public interface MessageHandler {

	void handle(Channel channel, ChatMessage message);

}
