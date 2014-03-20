package chat.client;

public class ChatUser {
	private ChatClient client;
	
	public ChatUser() throws Exception {
		client = new ChatClient();
		client.run();
	}

	public void sendMessage(String msg) {
		client.sendMessage(msg);
	}

	public static void main(String[] args) throws Exception {
		ChatUser user = new ChatUser();
		user.sendMessage("hello world");
	}
}
