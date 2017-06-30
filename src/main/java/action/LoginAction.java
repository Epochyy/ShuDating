package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.*;
import entity.*;
import org.apache.struts2.ServletActionContext;

public class LoginAction extends ActionSupport{
	private UserInfo user;
	public UserInfo getUser() {
		return this.user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
	public String execute() throws Exception {
		DatingDaoImp db = new DatingDaoImp();

		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		UserInfo user1 = db.getUserByName(user.getUsername());
		if(user1.getPassword().equals(user.getPassword())){
			ServletActionContext.getRequest().getSession().setAttribute("user",user1);
			return "success";
		}
		else {
			return "error";
		}
	}


}
