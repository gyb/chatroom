package chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import chat.message.ChatMessage;

public class ChatClient {
    public final static String DEFAULT_HOST = "localhost";
    public final static int DEFAULT_PORT = 5678;

    private final String host;
    private final int port;
    private final int userId;
    
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
             .handler(new ChatClientInitializer(userId));

            // Start the client.
            Channel channel = b.connect(host, port).sync().channel();

            // Read commands from the stdin.
            ChannelFuture lastWriteFuture = null;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String line = in.readLine();
                if (line == null) {
                    break;
                }

                // Sends the received line to the server.
                lastWriteFuture = channel.writeAndFlush(new ChatMessage(new Random().nextInt(), ChatMessage.TYPE_CHAT, userId, line));

                // If user typed the 'bye' command, wait until the server closes
                // the connection.
                if ("exit".equals(line.toLowerCase()) || "bye".equals(line.toLowerCase())) {
                	channel.closeFuture().sync();
                    break;
                }
            }

            // Wait until all messages are flushed before closing the channel.
            if (lastWriteFuture != null) {
                lastWriteFuture.sync();
            }
        } finally {
            // Shut down the event loop to terminate all threads.
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
    	new ChatClient().run();
    }
}
