package action;

import java.util.*;
import dao.*;
import entity.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport{
	private UserInfo user;
	private String item="";
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();		//获取对话对象，用来保存当前登录用户信息
		List<UserInfo> list = new ArrayList<UserInfo>();
		if(item.equals("")){
			session.put("list", list);
			return "success";
		}else {
			UserInfo usr = null;
			usr = (UserInfo) session.get("user");
			String[] items = item.split(", ");
			System.out.println(items[0] + "ksk");
			System.out.println(items[1] + "ksk");
			DatingDao dbCon = new DatingDaoImp();
			list = dbCon.searchUser(usr.getUsername(), items);
			session.put("list", list);
			return "success";
		}
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
}
