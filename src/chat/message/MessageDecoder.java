package chat.message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LineBasedFrameDecoder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageDecoder extends LineBasedFrameDecoder {
	private final static Logger logger = Logger.getLogger(MessageDecoder.class.getName());

	public MessageDecoder(final int maxLength) {
		super(maxLength);
	}

	@Override
	protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer)
			throws Exception {
		ByteBuf byteBuf = (ByteBuf)super.decode(ctx, buffer);
		if (byteBuf == null) {
			return null;
		}

		String json = byteBuf.toString(ChatMessage.charset);
		try {
			return ChatMessage.fromJson(json);
		} catch (Exception ex) {
			logger.log(Level.WARNING, "Parsing json message error. json is " + json, ex);
			return null;
		}
	}

}
