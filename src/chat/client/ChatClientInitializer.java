package chat.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LoggingHandler;

import java.util.Random;

import chat.message.ChatMessage;
import chat.message.MessageDecoder;
import chat.message.MessageEncoder;

public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {
	private int userId;
	
	public ChatClientInitializer() {
		this.userId = new Random().nextInt(99999);
	}

	public ChatClientInitializer(int userId) {
		this.userId = userId;
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		
		pipeline.addLast("decoder", new MessageDecoder(ChatMessage.MESSAGE_MAX_LENGTH));
		pipeline.addLast("encoder", new MessageEncoder());
		pipeline.addLast("logger", new LoggingHandler());
		pipeline.addLast("handler", new ChatClientHandler(userId));
	}

}
