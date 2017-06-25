package action;
import java.sql.ResultSet;
import java.util.Map;

import model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import db.*;

public class AddfriendsAction extends ActionSupport{
	private User user;
	private String FriendName;
	public String execute() throws Exception {
		System.out.print(FriendName);
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		User usr = null;
		usr = (User)session.get("user");
		DB dbCon = new DB();
		String sql;
		ResultSet rs = dbCon.AddFriend(FriendName);
		int friendId = 0; //好友用户ID
		while(rs.next()){
			friendId = rs.getInt(1);
		}
		sql = "insert into friend values(" + usr.getId() + "," + friendId + ")";
		boolean flag1 = dbCon.executeUpdate(sql);
		sql = "insert into friend values(" + friendId + "," + usr.getId() + ")";
		boolean flag2 = dbCon.executeUpdate(sql);
		if(flag1 && flag2) return "success";
		else return "error";
	}

	public String getFriendName() {
		return FriendName;
	}

	public void setFriendName(String friendName) {
		FriendName = friendName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
