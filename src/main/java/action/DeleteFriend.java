package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DB;

public class DeleteFriend extends ActionSupport {
	private User friends;

	public User getFriends() {
		return friends;
	}

	public void setFriends(User friends) {
		this.friends = friends;
	}

	public String execute() throws Exception {
		DB db = new DB();
		try {
			ActionContext context = ActionContext.getContext();
			Map session = context.getSession();
			User user1 = (User) session.get("user");
			int friendid = friends.getId();
			db.deleteFriend(user1, friendid);
			ArrayList a1 = db.ShowAllFriends(user1);
			session.put("friendstable", a1);
			ArrayList a = db.getMail(user1);
			session.put("mail", a);
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

}
