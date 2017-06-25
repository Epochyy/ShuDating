package db;
import java.sql.*;
import java.util.*;

import model.*;

import com.opensymphony.xwork2.ActionContext;

public class DB {
	Connection ct;
	PreparedStatement pstmt;
	PreparedStatement pstmt2;
	public DB(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Dating","manager","yangchen");
			}
		catch(Exception e){
				e.printStackTrace();
			}
	}
	public boolean  register(User user){
		try{
			ResultSet rs;
			pstmt=ct.prepareStatement("select * from userinfo where username=?");
			pstmt.setString(1, user.getUsername());
			rs = pstmt.executeQuery();
			if(rs.next()){
				pstmt.close();
				ct.close();
				return false;
			}
			pstmt=ct.prepareStatement("insert into userinfo (username, password, realname, gender, age, sexlike, phone, photo) values(?,?,?,?,?,?,?,?)");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getRealname());
			pstmt.setString(4, user.getGender());
			pstmt.setInt(5,user.getAge());
			pstmt.setString(6, user.getSexlike());
			pstmt.setString(7, user.getPhone());
			pstmt.setString(8, user.getPhoto());
			pstmt.executeUpdate();
			pstmt.close();
			ct.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean login(User user){
		try{
			ResultSet rs;
			pstmt=ct.prepareStatement("select * from userinfo where username=? and password=?");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRealname(rs.getString(4));
				user.setGender(rs.getString(5));
				user.setAge(rs.getInt(6));
				user.setSexlike(rs.getString(7));
				user.setPhoto(rs.getString(8));
				user.setMotto(rs.getString(9));
				user.setRequirement(rs.getString(10));
				user.setPhone(rs.getString(11));
				user.setQq(rs.getString(12));
				user.setLabel1(rs.getInt(13));
				user.setLabel2(rs.getInt(14));
				user.setLabel3(rs.getInt(15));
				user.setLabel4(rs.getInt(16));
				user.setLabel5(rs.getInt(17));
				user.setLabel6(rs.getInt(18));
				user.setLabel7(rs.getInt(19));
				ActionContext context = ActionContext.getContext();
				Map session = context.getSession();
				session.put("user", user);
				pstmt.close();
				ct.close();
				return true;
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	//更改用户信息
	public boolean changeuserInfo(User user){
		try{
			pstmt=ct.prepareStatement("update userinfo set sexlike=?,photo=?, motto=?,requirement=?,phone=?,qq=?,label1=?,label2=?,label3=?,label4=?,label5=?,label6=?,label7=? where id =?");
			pstmt.setString(1,user.getSexlike());
			pstmt.setString(2,user.getPhoto());
			pstmt.setString(3,user.getMotto());
			pstmt.setString(4,user.getRequirement());
			pstmt.setString(5,user.getPhone());
			pstmt.setString(6,user.getQq());
			pstmt.setInt(7,user.getLabel1());
			pstmt.setInt(8,user.getLabel2());
			pstmt.setInt(9,user.getLabel3());
			pstmt.setInt(10,user.getLabel4());
			pstmt.setInt(11,user.getLabel5());
			pstmt.setInt(12,user.getLabel6());
			pstmt.setInt(13,user.getLabel7());
			pstmt.setInt(14,user.getId());
			pstmt.executeUpdate();
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	//发动态
	public boolean liuyan(User user,String s){
		try {
			pstmt= ct.prepareStatement("insert into news(username,news,time) values(?,?,?)");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, s);
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//查看自己动态
	public ArrayList findMyNews(User user){
		try {
				ArrayList al=new ArrayList();
				pstmt=ct.prepareStatement("select * from news where username = ?");
				pstmt.setString(1, user.getUsername());				
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					News ly=new News();
					ly.setUsername(rs.getString(2));
					ly.setTime(rs.getTimestamp(3));
					ly.setMessage(rs.getString(4));
					al.add(ly);
			}
			return al;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	//------------------显示好友动态------------------------------------------------------------------
	public ArrayList ShowFriendNews(User user) {
		try{
			pstmt=ct.prepareStatement("select id2 from friend where id1=?" );
			pstmt.setInt(1,user.getId());
			ArrayList al=new ArrayList();
			ResultSet rs=pstmt.executeQuery();
			PreparedStatement pstmt2;
			while(rs.next()){
				pstmt2=ct.prepareStatement("select username,news,time from news where uid=?" );
				pstmt2.setInt(1,rs.getInt(1));
				ResultSet rs2=pstmt2.executeQuery();
				while(rs2.next())
				{
					News n=new News();
					n.setUsername(rs2.getString(1));
					n.setMessage(rs2.getString(2));
					n.setTime(rs2.getTimestamp(3));
					al.add(n);
				}		
		}
		return al;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//显示最新推送动态
	//------------------显示好友动态------------------------------------------------------------------
		public ArrayList ShowLatestNews() {
			try{
				pstmt=ct.prepareStatement("select username,news,time from news order by id desc" );
				ArrayList al=new ArrayList();
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					News n=new News();
					n.setUsername(rs.getString(1));
					n.setMessage(rs.getString(2));
					n.setTime(rs.getTimestamp(3));
					al.add(n);
				}		
				return al;
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
	//查看好友信息
	public User getFriendPage(User friend){
		try{
			ResultSet rs;
			User user = new User();
			pstmt=ct.prepareStatement("select * from userinfo where username=?");
			pstmt.setString(1, friend.getUsername());		
			rs = pstmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));		
				user.setRealname(rs.getString(4));
				
				user.setGender(rs.getString(5));
				user.setAge(rs.getInt(6));
				user.setSexlike(rs.getString(7));
				user.setPhoto(rs.getString(8));
				user.setMotto(rs.getString(9));
				user.setRequirement(rs.getString(10));
				user.setPhone(rs.getString(11));
				user.setQq(rs.getString(12));
				user.setLabel1(rs.getInt(13));
				user.setLabel2(rs.getInt(14));
				user.setLabel3(rs.getInt(15));
				user.setLabel4(rs.getInt(16));
				user.setLabel5(rs.getInt(17));
				user.setLabel6(rs.getInt(18));
				user.setLabel7(rs.getInt(19));
				ActionContext context = ActionContext.getContext();
				
				pstmt.close();
				ct.close();
				return user;
			}
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//搜索
	public ResultSet executeQuery(String sql) throws SQLException {
		ResultSet rs;
		pstmt = ct.prepareStatement(sql);
		rs = pstmt.executeQuery();
		return rs;
	}
	public ResultSet AddFriend(String friend) throws SQLException {
		ResultSet rs;
		
		pstmt=ct.prepareStatement("select id from userinfo where username = ?");
		pstmt.setString(1, friend);	
		//pstmt = ct.prepareStatement(sql);
		rs = pstmt.executeQuery();
		return rs;
	}
	public boolean executeUpdate(String sql) throws SQLException {
		pstmt = ct.prepareStatement(sql);
		int flag = pstmt.executeUpdate();
		if (flag == 0) {
			return false;
		} else {
			return true;
		}
	}
	// ------------------信箱——显示好友列表--------------------------------------------------------------------
		public ArrayList ShowAllFriends(User user) {
			try {
				pstmt = ct.prepareStatement("select * from friend where id1=? order by id1");
				pstmt.setInt(1, user.getId());
				ArrayList a = new ArrayList();
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					User user1 = new User();
					pstmt2 = ct.prepareStatement("select username,gender,motto,photo from userinfo where id=? order by id");
					pstmt2.setInt(1, rs.getInt(2));
					ResultSet rs2 = pstmt2.executeQuery();
					if (rs2.next()) {
						user1.setUsername(rs2.getString(1));
						user1.setGender(rs2.getString(2));
						user1.setMotto(rs2.getString(3));
						user1.setPhoto(rs2.getString(4));
					}
					user1.setId(rs.getInt(2));
					a.add(user1);
				}
				return a;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		// ------------------信箱——得到该用户收到其它好友消息的记录包括已读未读--------------------------------------------------------------------
		public ArrayList getMail(User user) {
			try {
				pstmt = ct.prepareStatement("select * from mail where receiver=? order by receiver");
				pstmt.setInt(1, user.getId());
				ArrayList a = new ArrayList();
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					Mail m = new Mail();
					m.setSender(rs.getInt(2));
					m.setReceiver(rs.getInt(3));
					m.setTime(rs.getTimestamp(4));
					m.setIfread(rs.getInt(6));
					a.add(m);
				}
				return a;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		// ------------------信箱——获取历史消息记录(在用户登录时便获取)--------------------------------------------------------------------
		public ArrayList getHistoryMessage(User user1, User user2) {
			try {
				pstmt = ct.prepareStatement("select * from mail where receiver=? and sender=? union select * from mail where receiver=? and sender=? order by time");
				pstmt.setInt(1, user1.getId());
				pstmt.setInt(2, user2.getId());
				pstmt.setInt(3, user2.getId());
				pstmt.setInt(4, user1.getId());
				ArrayList a = new ArrayList();
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					Mail mail = new Mail();
					mail.setReceiver(rs.getInt(3));
					mail.setSender(rs.getInt(2));
					mail.setTime(rs.getTimestamp(4));
					mail.setMail(rs.getString(5));
					a.add(mail);
				}
				return a;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		// ------------------信箱——发消息--------------------------------------------------------------------
		public void Sendmessage(User user1, User user2, String mail)
				throws SQLException {

			pstmt = ct.prepareStatement("INSERT into mail(sender,receiver,time,mail,ifread) values (?,?,?,?,?)");
			pstmt.setInt(1, user1.getId());
			pstmt.setInt(2, user2.getId()); // 这里的接受者如何在页面获取？
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(4, mail);
			pstmt.setInt(5, 0); // 我给其它用户发信息，全部为对方未读
			pstmt.executeUpdate();

		}

		// ------------------信箱——由好友id获取User对象成为friend--------------------------------------------------------------------
		public User getMyFriend(int friendid) {
			try {
				pstmt = ct.prepareStatement("select * from userinfo where id=?");
				pstmt.setInt(1, friendid);
				ResultSet rs = pstmt.executeQuery();
				User user = new User();
				if (rs.next()) {
					user.setId(rs.getInt(1));
					user.setUsername(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setRealname(rs.getString(4));
					user.setGender(rs.getString(5));
					user.setAge(rs.getInt(6));
					user.setSexlike(rs.getString(7));
					user.setMotto(rs.getString(9));
					return user;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		// ------------------信箱———点击查看消息的链接后，将ifread更新为已读1--------------------------------------------------------------------
		public void updateIfRead(User user1, User user2) throws SQLException {

			pstmt = ct.prepareStatement("update mail set ifread=1 where sender=? and receiver=?");
			pstmt.setInt(1, user2.getId());
			pstmt.setInt(2, user1.getId());
			pstmt.executeUpdate();

		}

		// ------------------信箱———根据当前用户和点击的好友的id删除好友,与此同时，删除他们之间的聊天记录-------------------------------------------------------------------
		public void deleteFriend(User user1, int friendid) throws SQLException {

			pstmt = ct.prepareStatement("delete from friend where id1=? and id2=? or id1=? and id2=?");
			pstmt.setInt(1, user1.getId());
			pstmt.setInt(2, friendid);
			pstmt.setInt(3, friendid);
			pstmt.setInt(4, user1.getId());
			pstmt.executeUpdate();

			pstmt2 = ct.prepareStatement("delete from mail where sender=? and receiver=? or sender=? and receiver=?");
			pstmt2.setInt(1, user1.getId());
			pstmt2.setInt(2, friendid);
			pstmt2.setInt(3, friendid);
			pstmt2.setInt(4, user1.getId());
			pstmt2.executeUpdate();

		}
}
