package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DB;

public class ShowMessage extends ActionSupport {
	private User friends;

	public User getFriends() {
		return friends;
	}

	public void setFriends(User friends) {
		this.friends = friends;
	}

	public String execute() throws Exception {
		try {
			DB db = new DB();
			ActionContext context = ActionContext.getContext();
			Map session = context.getSession();
			int friendid = friends.getId();
			User myfriend = new User();
			myfriend = db.getMyFriend(friendid);
			session.put("friend", myfriend);
			User user1 = (User) session.get("user");
			ArrayList a3 = db.getHistoryMessage(user1, myfriend);
			session.put("historymessage", a3);
			db.updateIfRead(user1, myfriend);
			// ArrayList a1=db.ShowAllFriends(user1);
			// session.put("friendstable",a1);
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

}
