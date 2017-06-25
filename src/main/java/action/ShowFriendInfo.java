package action;

import java.util.Map;

import model.*;
import db.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowFriendInfo extends ActionSupport{
	private User friends;

	public User getFriends() {
		return friends;
	}

	public void setFriends(User friends) {
		this.friends = friends;
	}
	
	public String execute() throws Exception {
		try {
			DB db=new DB();

			ActionContext context=ActionContext.getContext(); 
			Map session=context.getSession();
			User a=db.getFriendPage(friends);
			session.put("friendpage", a);
			return "success";
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
}
