package action;

import java.util.ArrayList;
import java.util.Map;

import entity.*;

import com.opensymphony.xwork2.ActionContext;

import dao.*;

public class ShowNews {
	private News news;
	public String execute() throws Exception {
		try {
			DatingDaoImp db = new DatingDaoImp();
			ActionContext context = ActionContext.getContext();
			Map session = context.getSession();
			UserInfo user1 = (UserInfo) session.get("user");
			ArrayList al=(ArrayList) db.getMyNews(user1);
			session.put("MyNews", al);
			return "success";
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
		
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
}
