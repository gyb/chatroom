package chat.server.clients;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.google.common.collect.Maps;

public class ClientsManager {
	private final static Logger logger = Logger.getLogger(ClientsManager.class.getName());
	
	private static final Map<Integer, Channel> clientsChannelMap = Maps.newConcurrentMap();
	private static final Map<Channel, Integer> clientsIdMap = Maps.newConcurrentMap();
	
	public static void add(Integer userId, Channel channel) {
		clientsChannelMap.put(userId, channel);
		clientsIdMap.put(channel, userId);
		logger.info("User " + userId + " connected");
	}
	
	public static void remove(Channel channel) {
		Integer userId = clientsIdMap.remove(channel);
		if (userId != null) {
			logger.info("User " + userId + " disconnected");
			clientsChannelMap.remove(userId);
		}
	}
	
	public static Channel get(Integer userId) {
		return clientsChannelMap.get(userId);
	}
	
	public static Set<Channel> getChannels() {
		return clientsIdMap.keySet();
	}
}
