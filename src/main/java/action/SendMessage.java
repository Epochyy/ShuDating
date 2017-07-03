package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import dao.*;
import entity.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SendMessage extends ActionSupport {
	private Mail message;

	public Mail getMessage() {
		return message;
	}

	public void setMessage(Mail message) {
		this.message = message;
	}

	public String execute() throws ClassNotFoundException {
		DatingDaoImp db = new DatingDaoImp();
		try {
			ActionContext context = ActionContext.getContext();
			Map session = context.getSession();
			UserInfo user1 = (UserInfo) session.get("user");
			UserInfo user2 = (UserInfo) session.get("friend");
			db.sendMessage(user1, user2, message.getMail());
			ArrayList a3 = new ArrayList();
			//a3.AddRange(db.getHistoryMessage(user1, user2));
			a3 = (ArrayList) db.getHistoryMessage(user1, user2);
			session.put("historymessage", a3);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

}
