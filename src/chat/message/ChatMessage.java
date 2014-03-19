package chat.message;

import java.nio.charset.Charset;

import com.google.gson.Gson;

public class ChatMessage {
	public final static Charset charset = Charset.forName("ISO-8859-1");
	public final static int MESSAGE_MAX_LENGTH = 100000;
	private final static Gson gson = new Gson();

	private int type;
	private int sender;
	private int group;
	private int receiver;
	private String content;
	private String sendTime;
	
	public static ChatMessage fromJson(String json) {
		return gson.fromJson(json, ChatMessage.class);
	}

	public String toJson() {
		return gson.toJson(this, ChatMessage.class);
	}

	public int getType() {
		return type;
	}

	public int getSender() {
		return sender;
	}

	public int getGroup() {
		return group;
	}

	public int getReceiver() {
		return receiver;
	}

	public String getContent() {
		return content;
	}

	public String getSendTime() {
		return sendTime;
	}

	public final static int TYPE_LOGIN = 1;
	public final static int TYPE_CHAT = 2;
//	public final static int SUCCESS =0;//表明是否成功
//	public final static int FAIL =1;//表明失败
//	public final static int COM_MES =2;//普通信息包
//	public final static int GROUP_MES =3;//群消息
//	public final static int GET_ONLINE_FRIENDS =4;
//	public final static int RET_ONLINE_FRIENDS =5;//返回在线好友的包
//	public final static int LOGIN =6;//请求验证登陆
//	public final static int SEARCH_FRIEND =7;//查找好友
//	public final static int SEARCH_FRIEND_RESULT =8;//查找好友结果
//	public final static int ADD_FRIEND_REQUEST =9;//请求添加好友
//	public final static int ADD_FRIEND_REPLY =10;//返回添加好友
//	public final static int DEL_FRIEND =11;//删除好友
//	public final static int SERVER_CACHE_REQUEST =12;//请求离线消息
//	public final static int SERVER_CACHE_REPLY =13;//返回离线消息结果
//	public final static int ADD_FRIEND_SUCCESS = 14;//添加好友成功 
//	public final static int ADD_FRIEND_REJECT = 15;//拒绝添加好友
//	public final static int CREATE_GROUP =16;//创建群
//	public final static int CREATE_GROUP_SUCCESS = 17;//创建群成功
//	public final static int SEARCH_GROUP =18;//查找群
//	public final static int SEARCH_GROUP_RESULT =19;//查找群结果
//	public final static int ADD_GROUP_REQUEST =20;//加入群请求
//	public final static int ADD_GROUP_REPLY =21;//返回加入群请求
//	public final static int ADD_GROUP_SUCCESS =22;//加入群请求成功
//	public final static int ADD_GROUP_REJECT =23;//加入群请求拒绝
//	public final static int GET_GROUP_INFO =24;//获取群信息
//	public final static int GET_GROUP_INFO_RESULT =25;//获取群信息结果
//	public final static int QUIT_GROUP =26;//退出群
//	public final static int SERVER_NOTICE_REQUEST =27;//请求服务器公告
//	public final static int SERVER_NOTICE_REPLY =28;//服务器公告结果
//	public final static int GET_USER_INFO_REQUEST =29;//查询单个人信息
//	public final static int GET_USER_INFO_REPLY =30;//查询单个人信息结果
//	
//	public final static int GET_MY_GROUP =31;//查询我的群组
//	public final static int GET_MY_GROUP_RESULT =32;//查询我的群组结果
//	public final static int GET_ALL_PUBLIC_GROUP =33;//查询所有群组
//	public final static int GET_ALL_PUBLIC_GROUP_RESULT =34;//查询所有群组结果
//	public final static int SCHO_TEAM_MSG =35;//思酷团队消息
//	
//	public final static int GROUP_ADD_MEMBER_REQUEST =36;//群组增加成员请求
//	public final static int GROUP_ADD_MEMBER_REPLAY =37;//群组增加成员结果
//	public final static int GROUP_DELETE_MEMBER_REQUEST =38;//群组删除成员请求
//	public final static int GROUP_DELETE_MEMBER_REPLAY =39;//群组删除成员结果
//
//	public final static int HEART_BEAT_PKG =40;//心跳包检测
//	
//	public final static int ADDED_TO_GROUP =41;//创建群组时被加入群  或  被拉入群
//	
//	public final static int GET_MY_FRIENDS =42;//请求我的好友列表
//	public final static int RET_MY_FRIENDS =43;//返回我的好友列表
//	
//	public final static int TERMINATE_CONNECT =44;//断开连接
}
