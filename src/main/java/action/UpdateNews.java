package action;

import java.util.Map;


import model.*;
import db.*;

import com.opensymphony.xwork2.ActionContext;


public class UpdateNews {

	private String ly;
	public String execute() throws Exception {
		System.out.println(ly);
		DB db = new DB();
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		User user1 = (User)session.get("user");
		System.out.println(user1.getUsername());
		//ly.setUsername(user1.getUsername());
		//System.out.println(ly.getUsername());
		
		if(db.liuyan(user1,ly)){
			
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
