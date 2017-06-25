package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import model.Mail;
import model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DB;

public class SendMessage extends ActionSupport {
	private Mail message;

	public Mail getMessage() {
		return message;
	}

	public void setMessage(Mail message) {
		this.message = message;
	}

	public String execute() throws ClassNotFoundException {
		DB db = new DB();
		try {
			ActionContext context = ActionContext.getContext();
			Map session = context.getSession();
			User user1 = (User) session.get("user");
			User user2 = (User) session.get("friend");
			db.Sendmessage(user1, user2, message.getMail());
			ArrayList a3 = db.getHistoryMessage(user1, user2);
			session.put("historymessage", a3);
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

}
