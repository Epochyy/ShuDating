package action;

import java.util.*;
import entity.*;
import dao.*;
import com.opensymphony.xwork2.ActionContext;

public class ShowLatestNews {
	public String execute() throws Exception {
		try {
			DatingDaoImp db=new DatingDaoImp();
			ActionContext context=ActionContext.getContext(); 
			Map session=context.getSession();
			ArrayList a=(ArrayList) db.getLatestNews();
			System.out.print(a);
			session.put("latestnews", a);
			return "success";
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
