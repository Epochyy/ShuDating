package action;

import java.util.ArrayList;
import java.util.Map;

import entity.*;
import dao.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowFriendNews extends ActionSupport{

	public String execute() throws Exception {
		try {
			DatingDaoImp db=new DatingDaoImp();
			ActionContext context=ActionContext.getContext(); 
			Map session=context.getSession();
			UserInfo user1=(UserInfo) session.get("user");
			ArrayList a=(ArrayList) db.getFirendsNews(user1);
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
