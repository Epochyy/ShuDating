package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import dao.*;
import entity.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteFriend extends ActionSupport {
	private UserInfo friends;

	public UserInfo getFriends() {
		return friends;
	}

	public void setFriends(UserInfo friends) {
		this.friends = friends;
	}

	public String execute() throws Exception {
		DatingDaoImp db = new DatingDaoImp();
		try {
			ActionContext context = ActionContext.getContext();
			Map session = context.getSession();
			UserInfo user1 = (UserInfo) session.get("user");
			int friendid = friends.getId();
			//É¾³ý
			db.deleteFriend(user1, friendid);
			ArrayList a1 = (ArrayList) db.getAllFriend(user1);
			session.put("friendstable", a1);
			ArrayList a = (ArrayList) db.getReceiveMail(user1);
			session.put("mail", a);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

}
