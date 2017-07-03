package action;

import java.util.ArrayList;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.DatingDaoImp;
import entity.Friend;
import entity.UserInfo;


public class EnterFriend extends ActionSupport {
	private UserInfo user;

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String execute() throws ClassNotFoundException {
		DatingDaoImp db = new DatingDaoImp();
		try {
			ActionContext context = ActionContext.getContext();
			Map session = context.getSession();
			UserInfo user1 = (UserInfo) session.get("user");
			ArrayList a1 = (ArrayList) db.getAllFriend(user1);
			ArrayList fl=new ArrayList<UserInfo>();
			for (Object item:
				 a1) {
				fl.add(db.getUserById(((Friend) item).getId2()));
			}
			session.put("friendstable", fl);
			ArrayList a = (ArrayList) db.getReceiveMail(user1);
			session.put("mail", a);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

}
