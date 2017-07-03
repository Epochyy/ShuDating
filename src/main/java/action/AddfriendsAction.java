package action;

import java.util.Map;
import dao.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.*;

public class AddfriendsAction extends ActionSupport{
//	private UserInfo user;
	private String FriendName;
	public String execute() throws Exception {
		System.out.print(FriendName);
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		UserInfo usr = null;
		usr = (UserInfo)session.get("user");
		DatingDao dbCon = new DatingDaoImp();
		int friendId = dbCon.getUserByName(FriendName).getId(); //好友用户ID
		System.out.println(friendId);
		boolean flag= dbCon.addFriend(usr,friendId);
		System.out.println("fgsgfds");
		if(flag) return "success";
		else return "error";
	}

	public String getFriendName() {
		return FriendName;
	}

	public void setFriendName(String friendName) {
		FriendName = friendName;
	}

//	public UserInfo getUser() {
//		return user;
//	}
//
//	public void setUser(UserInfo user) {
//		this.user = user;
//	}
}
