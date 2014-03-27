package chat.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import chat.message.ChatMessage;

public class ConfirmReceivedHandler extends SimpleChannelInboundHandler<ChatMessage> {
	
	public ConfirmReceivedHandler() {
		super(false);
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ChatMessage msg)
			throws Exception {
		if (msg.getType() == ChatMessage.TYPE_CHAT) {
			ChatMessage message = new ChatMessage(0, ChatMessage.TYPE_CONFIRM, 0, "" + msg.getId());
	        ctx.channel().writeAndFlush(message);
		}
        ctx.fireChannelRead(msg);
	}

}
