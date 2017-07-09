package action;

import java.util.Map;

import dao.DatingDaoImp;
import entity.UserInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowFriendInfo extends ActionSupport{
	private UserInfo friends;

	public UserInfo getFriends() {
		return friends;
	}

	public void setFriends(UserInfo friends) {
		this.friends = friends;
	}
	
	public String execute() throws Exception {
		try {
			DatingDaoImp db=new DatingDaoImp();

			ActionContext context=ActionContext.getContext(); 
			Map session=context.getSession();
			UserInfo a=db.getFriendPage(friends);
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
