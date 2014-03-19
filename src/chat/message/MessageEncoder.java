package chat.message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MessageEncoder extends MessageToByteEncoder<ChatMessage> {

	@Override
	protected void encode(ChannelHandlerContext ctx, ChatMessage msg, ByteBuf out)
			throws Exception {
		out.writeBytes(msg.toJson().getBytes(ChatMessage.charset))
		   .writeByte('\n');  //delimiter
	}

}
