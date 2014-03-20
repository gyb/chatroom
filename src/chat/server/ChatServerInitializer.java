package chat.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import chat.message.ChatMessage;
import chat.message.MessageDecoder;
import chat.message.MessageEncoder;

public class ChatServerInitializer extends ChannelInitializer<SocketChannel> {
	private static final EventExecutorGroup group = new DefaultEventExecutorGroup(8);

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("decoder", new MessageDecoder(ChatMessage.MESSAGE_MAX_LENGTH));
        pipeline.addLast("encoder", new MessageEncoder());
        pipeline.addLast("logger", new LoggingHandler());
        pipeline.addLast(group, "handler", new ChatServerHandler());
	}

}
