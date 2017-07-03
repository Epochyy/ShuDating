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
	/*public void validate() { //手工方式验证登录的时候用户名密码是否是空
		if (user.getUsername() == null || user.getUsername().trim().equals("")) {
			addFieldError("user.username", "请输入用户名");
		}
		if (user.getPassword() == null ||user.getPassword().trim().equals("")) {
			addFieldError("user.password", "请输入密码");
		}
   }*/
	public String execute() throws Exception {
		DatingDaoImp db = new DatingDaoImp();
		UserInfo user1 = db.getUserByName(user.getUsername());
		if(user1.getPassword().equals(user.getPassword())){
			ServletActionContext.getContext().getSession().put("user",user1);
			return "success";
		}
		else {
			return "error";
		}
	}
	

}
