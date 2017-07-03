package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import dao.*;
import entity.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class MailFriendsUpdate extends ActionSupport {
	private UserInfo user;

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String execute() throws Exception {
		DatingDaoImp db = new DatingDaoImp();
		try{
			ActionContext context = ActionContext.getContext();
			Map session = context.getSession();
			UserInfo user1 = (UserInfo) session.get("user");
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
