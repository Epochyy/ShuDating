package dao;

import entity.Mail;
import entity.UserInfo;

import java.util.List;

/**
 * @Title: DatingDao
 * @Description: Dao接口类
 * @Author: 易媛
 * @Date: 2017/6/24.
 */
public interface DatingDao {
    UserInfo getUserById(int id);
    UserInfo getUserByName(String username);
    boolean addUser(UserInfo userInfo);
    boolean alterUserName(String username,UserInfo user);
    boolean alterGender(String gender,UserInfo user);
    boolean alterPassword(String password,UserInfo user);
    boolean alterAge(int age,UserInfo user);
    boolean alterSexLike(String sexlike,UserInfo user);
    boolean alterPhoto(String photo,UserInfo user);
    boolean alterQq(String qq,UserInfo user);
    boolean alterLables(String[] labels,UserInfo user);
    boolean addNews(UserInfo user,String news);
    List getMyNews(UserInfo user);
    List getFirendsNews(UserInfo user);
    List getLatestNews();
    UserInfo getFriendPage(UserInfo friend);
    List searchUser(String myname,String[] regx);
    boolean addFriend(UserInfo user,int fid);
    List getAllFriend(UserInfo user);
    List getReceiveMail(UserInfo user);//收到的消息
    List getHistoryMessage(UserInfo user1,UserInfo user2);//消息记录
    boolean sendMessage(UserInfo user1,UserInfo user2,String mail);
    //boolean updateIfRead(UserInfo user1,UserInfo user2);
    boolean updateIfRead(Mail mail);
    boolean deleteFriend(UserInfo user,int fid);
    boolean removeLables(String label,UserInfo user);
}
