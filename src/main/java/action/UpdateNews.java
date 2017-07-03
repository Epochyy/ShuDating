package action;

import java.util.Map;


import entity.*;
import dao.*;

import com.opensymphony.xwork2.ActionContext;


public class UpdateNews {

	private String ly;
	public String execute() throws Exception {
		System.out.println(ly);
		DatingDaoImp db = new DatingDaoImp();
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		UserInfo user1 = (UserInfo) session.get("user");
		System.out.println(user1.getUsername());
		//ly.setUsername(user1.getUsername());
		//System.out.println(ly.getUsername());
		
		if(db.addNews(user1,ly)){
			
			return "success";
		}
		else {
			return "error";
		}
	}
	public String getLy() {
		return ly;
	}
	public void setLy(String ly) {
		this.ly = ly;
	}
}
