package action;
import java.sql.*;
import java.util.*;
import db.*;
import model.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport{
	private User user;
	private String item;
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();		//获取对话对象，用来保存当前登录用户信息
		User usr = null;
		usr = (User)session.get("user");
		System.out.println(item);
		String[] items = item.split(", ");
		String[] label = {"文学青年", "影视音乐", "体育健身", "游戏娱乐", "美食专家", "二次元", "学霸无双"};
		labels lbs1 = null;
		lbs1 = new labels();
		for(int i=0; i<items.length; i++){
			if(items[i].equals(label[0])){ lbs1.setLabel1(1); continue;}
			if(items[i].equals(label[1])){ lbs1.setLabel2(1); continue;}
			if(items[i].equals(label[2])){ lbs1.setLabel3(1); continue;}
			if(items[i].equals(label[3])){ lbs1.setLabel4(1); continue;}
			if(items[i].equals(label[4])){ lbs1.setLabel5(1); continue;}
			if(items[i].equals(label[5])){ lbs1.setLabel6(1); continue;}
			if(items[i].equals(label[6])){ lbs1.setLabel7(1); continue;}
		}
		DB dbCon = new DB();
		String sql = "select * from userinfo";
		ResultSet rs = dbCon.executeQuery(sql);
		List<match> list = new ArrayList<match>();
		while(rs.next()){
			if(rs.getString(2).equals(usr.getUsername())) continue; //搜索到当前用户信息，则跳过
			int matching = 0;  //匹配度
			if((lbs1.getLabel1() == rs.getInt(13)) && rs.getInt(13) == 1) matching++;
			if((lbs1.getLabel2() == rs.getInt(14)) && rs.getInt(14) == 1) matching++;
			if((lbs1.getLabel3() == rs.getInt(15)) && rs.getInt(15) == 1) matching++;
			if((lbs1.getLabel4() == rs.getInt(16)) && rs.getInt(16) == 1) matching++;
			if((lbs1.getLabel5() == rs.getInt(17)) && rs.getInt(17) == 1) matching++;
			if((lbs1.getLabel6() == rs.getInt(18)) && rs.getInt(18) == 1) matching++;
			if((lbs1.getLabel7() == rs.getInt(19)) && rs.getInt(19) == 1) matching++;
			System.out.println(matching);
			match mt = new match();
			mt.setUsername(rs.getString(2));
			mt.setNum(matching);
			list.add(mt);
		}
		// 对list中的元素由匹配度升序排序，若匹配度相同，则由字母顺序排序
		Collections.sort(list, new Comparator<match>(){
			public int compare(match m1, match m2){
				if(m1.getNum() != m2.getNum()) 
					return m2.getNum()-m1.getNum();
				else 
					return m1.getUsername().compareTo(m2.getUsername()); 
			}
		});
		session.put("list", list);
		return "success";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
}
