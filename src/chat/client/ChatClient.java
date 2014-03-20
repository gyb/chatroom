package chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Random;

import chat.message.ChatMessage;

public class ChatClient {
    public final static String DEFAULT_HOST = "localhost";
    public final static int DEFAULT_PORT = 5678;

    private final String host;
    private final int port;
    
    private int userId;
    private Channel channel;
    
    public ChatClient() {
    	this(DEFAULT_HOST, DEFAULT_PORT);
    }

    public ChatClient(String host, int port) {
    	this.host = host;
    	this.port = port;
    	this.userId = new Random().nextInt(99999);
    }

    public void run() throws Exception {
        // Configure the client.
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioSocketChannel.class)
             .handler(new ChatClientInitializer());

            // Start the client.
            ChannelFuture f = b.connect(host, port).sync();
            this.channel = f.channel();
        } finally {
            // Shut down the event loop to terminate all threads.
            group.shutdownGracefully();
        }
    }
    
    public void sendMessage(String msg) {
    	channel.write(new ChatMessage(ChatMessage.TYPE_CHAT, userId, msg));
    	channel.flush();
    }
}
