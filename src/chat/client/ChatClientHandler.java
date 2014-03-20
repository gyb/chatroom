package chat.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.logging.Logger;

import chat.message.ChatMessage;

public class ChatClientHandler extends SimpleChannelInboundHandler<ChatMessage> {
	private final static Logger logger = Logger.getLogger(ChatClientHandler.class.getName());

	private Integer userId;
	
	public ChatClientHandler(Integer userId) {
		this.userId = userId;
	}

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(ChatMessage.fromJson("{\"type\":" + ChatMessage.TYPE_LOGIN + ", \"content\":" + userId + "}"));
    }

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ChatMessage msg)
			throws Exception {
    	logger.info("Received one msg:" + msg.getContent());
	}

}
