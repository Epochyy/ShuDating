package action;

import java.util.ArrayList;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.*;
import entity.*;

public class ShowMessage extends ActionSupport {
	private UserInfo friends;

	public UserInfo getFriends() {
		return friends;
	}

	public void setFriends(UserInfo friends) {
		this.friends = friends;
	}

	public String execute() throws Exception {
		try {
			DatingDaoImp db = new DatingDaoImp();
			ActionContext context = ActionContext.getContext();
			Map session = context.getSession();
			int friendid = friends.getId();
			UserInfo myfriend ;
			myfriend = db.getUserById(friendid);
			session.put("friend", myfriend);
			UserInfo user1 = (UserInfo) session.get("user");
			ArrayList a3 = (ArrayList) db.getHistoryMessage(user1, myfriend);
			session.put("historymessage", a3);
			db.updateIfRead(user1, myfriend);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

}
