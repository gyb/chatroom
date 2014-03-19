package chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ChatClient {
    public final static String DEFAULT_HOST = "localhost";
    public final static int DEFAULT_PORT = 5678;

    private final String host;
    private final int port;
    
    public ChatClient() {
    	this(DEFAULT_HOST, DEFAULT_PORT);
    }

    public ChatClient(String host, int port) {
    	this.host = host;
    	this.port = port;
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

            f.channel().closeFuture().sync();
        } finally {
            // Shut down the event loop to terminate all threads.
            group.shutdownGracefully();
        }
    }
}
