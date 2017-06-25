package action;

import model.*;

import com.opensymphony.xwork2.ActionSupport;

import db.DB;
public class LoginAction extends ActionSupport{
	private User user;
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
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
		DB db = new DB();
		//System.out.println(user.getUsername());
		//System.out.println(user.getPassword());
		if(db.login(user)){
			
			return "success";
		}
		else {
			return "error";
		}
	}
	

}
