package chat.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import chat.message.ChatMessage;
import chat.server.handler.ChatHandler;
import chat.server.handler.LoginHandler;
import chat.server.handler.UnknownTypeHandler;

public class ChatServerHandler extends SimpleChannelInboundHandler<ChatMessage> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ChatMessage msg)
			throws Exception {
		switch (msg.getType()) {
		case ChatMessage.TYPE_LOGIN:
			new LoginHandler().handle(ctx.channel(), msg);
			break;
		case ChatMessage.TYPE_CHAT:
			new ChatHandler().handle(ctx.channel(), msg);
			break;
		default:
			new UnknownTypeHandler().handle(ctx.channel(), msg);
			break;
		}
	}

}
