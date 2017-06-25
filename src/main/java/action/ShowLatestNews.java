package action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import db.DB;

public class ShowLatestNews {
	public String execute() throws Exception {
		try {
			DB db=new DB();
			ActionContext context=ActionContext.getContext(); 
			Map session=context.getSession();
			ArrayList a=db.ShowLatestNews();
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
