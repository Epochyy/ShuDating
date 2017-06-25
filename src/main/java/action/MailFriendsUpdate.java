package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DB;

public class MailFriendsUpdate extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {
		DB db = new DB();
		try {
			ActionContext context = ActionContext.getContext();
			Map session = context.getSession();
			User user1 = (User) session.get("user");
			ArrayList a1 = db.ShowAllFriends(user1);
			session.put("friendstable", a1);
			ArrayList a = db.getMail(user1);
			session.put("mail", a);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

}
