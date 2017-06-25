package action;

import java.util.ArrayList;
import java.util.Map;

import model.News;
import model.User;

import com.opensymphony.xwork2.ActionContext;

import db.DB;

public class ShowNews {
	private News news;
	public String execute() throws Exception {
		try {
			DB db = new DB();
			ActionContext context = ActionContext.getContext();
			Map session = context.getSession();
			User user1 = (User)session.get("user");
			ArrayList al=db.findMyNews(user1);
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
