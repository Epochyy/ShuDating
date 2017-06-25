package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import model.*;
import db.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowFriendNews extends ActionSupport{

	public String execute() throws Exception {
		try {
			DB db=new DB();
			ActionContext context=ActionContext.getContext(); 
			Map session=context.getSession();
			User user1=(User) session.get("user");
			ArrayList a=db.ShowFriendNews(user1);
			System.out.print(a);
			session.put("friendnews", a);
			return "success";
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
}
