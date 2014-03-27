package chat.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import chat.message.ChatMessage;
import chat.message.MessageDecoder;
import chat.message.MessageEncoder;

public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {
	private int userId;
	
	public ChatClientInitializer(int userId) {
		this.userId = userId;
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		
		pipeline.addLast("decoder", new MessageDecoder(ChatMessage.MESSAGE_MAX_LENGTH));
		pipeline.addLast("encoder", new MessageEncoder());
		pipeline.addLast("handler", new ChatClientHandler(userId));
	}

}
