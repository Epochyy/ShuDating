package dao;

import entity.Friend;
import entity.Mail;
import entity.News;
import entity.UserInfo;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* DatingDaoImp Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 24, 2017</pre> 
* @version 1.0 
*/ 
public class DatingDaoImpTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: getUserById(int id)
    *
    */
    @Test
    public void testGetUserById() throws Exception {
        DatingDaoImp f=new DatingDaoImp();
        UserInfo user = f.getUserById(1);
        System.out.println(user.getId()+"\t"+user.getUsername()+"\t"+user.getPassword());
    //TODO: Test goes here...
    }

    /**
    *
    * Method: getUserByName(String username)
    *
    */
    @Test
    public void testGetUserByName() throws Exception {
    //TODO: Test goes here...
        DatingDaoImp f=new DatingDaoImp();
        UserInfo user = f.getUserByName("yy");
        System.out.println(user.getId()+"\t"+user.getUsername()+"\t"+user.getPassword());
    }

    /**
    *
    * Method: addUser(UserInfo userInfo)
    *
    */
    @Test
    public void testAddUser() throws Exception {
    //TODO: Test goes here...
        UserInfo user = new UserInfo();
        user.setUsername("lyc");
        user.setPassword("111111");
        user.setAge(20);
        user.setGender("女");
        user.setLabel1("电视迷");
        DatingDaoImp f = new DatingDaoImp();
        f.addUser(user);
    }

    /**
    *
    * Method: alterUserName(String username)
    *
    */
    @Test
    public void testAlterUserName() throws Exception {
    //TODO: Test goes here...
        UserInfo user=new UserInfo();
        DatingDaoImp d=new DatingDaoImp();
        user.setId(2);
        d.alterPassword("111111",user);
        d.alterAge(21,user);
        d.alterGender("迷",user);
        d.alterSexLike("正常",user);
        d.alterQq("1365423",user);
        String []labels={"电视","跑步"};
        d.alterLables(labels,user);
        user=d.getUserById(2);
        System.out.println(user.getUsername()+"\t"+user.getAge()+"\t"+user.getGender()+"\t"+user.getLabel1());
    }

    /**
    *
    * Method: alterGender(String gender)
    *
    */
    @Test
    public void testAlterGender() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: alterPassword(String password)
    *
    */
    @Test
    public void testAlterPassword() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: alterAge(int age)
    *
    */
    @Test
    public void testAlterAge() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: alterSexLike(String sexlike)
    *
    */
    @Test
    public void testAlterSexLike() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: alterPhoto(String photo)
    *
    */
    @Test
    public void testAlterPhoto() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: alterQq(String qq)
    *
    */
    @Test
    public void testAlterQq() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: alterLables(String[] labels)
    *
    */
    @Test
    public void testAlterLables() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: addNews(UserInfo user, String news)
    *
    */
    @Test
    public void testAddNews() throws Exception {
    //TODO: Test goes here...
        DatingDaoImp d=new DatingDaoImp();
        UserInfo u=d.getUserById(1);
        d.addNews(u,"authentic shit!");
    }

    /**
    *
    * Method: getMyNews(UserInfo User)
    *
    */
    @Test
    public void testGetMyNews() throws Exception {
    //TODO: Test goes here...
        UserInfo u=new UserInfo();
        u.setId(1);
        DatingDaoImp d=new DatingDaoImp();
        List l=d.getMyNews(u);
        for (Object item:l
             ) {
            System.out.println(((News) item).getNews());
        }
    }


    /**
    *
    * Method: getFirendsNews(UserInfo user)
    *
    */
    @Test
    public void testGetFirendsNews() throws Exception {
    //TODO: Test goes here...
        UserInfo user=new UserInfo();
        user.setId(2);
        DatingDaoImp d= new DatingDaoImp();
        List l=d.getFirendsNews(user);
        for (Object item:l
                ) {
            System.out.println(((News) item).getNews());
        }
    }

    /**
    *
    * Method: getLatestNews()
    *
    */
    @Test
    public void testGetLatestNews() throws Exception {
    //TODO: Test goes here...
        DatingDaoImp d= new DatingDaoImp();
        List list=d.getLatestNews();
        for (Object item:list
             ) {
            System.out.println(((News)item).getNews());
        }
    }

    /**
    *
    * Method: getFriendPage(UserInfo friend)
    *
    */
    @Test
    public void testGetFriendPage() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: searchUser(String regx)
    *
    */
    @Test
    public void testSearchUser() throws Exception {
    //TODO: Test goes here...
        String []regx={"电视","电影"};
        DatingDaoImp d=new DatingDaoImp();
        List list=d.searchUser("yy",regx);
        for (Object item:list
             ) {
            System.out.println(((UserInfo)item).getUsername());
        }
    }

    /**
    *
    * Method: addFriend(int fid)
    *
    */
    @Test
    public void testAddFriend() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: getAllFriend(UserInfo user)
    *
    */
    @Test
    public void testGetAllFriend() throws Exception {
    //TODO: Test goes here...
        UserInfo u=new UserInfo();
        u.setId(1);
        DatingDaoImp d=new DatingDaoImp();
        List l=d.getAllFriend(u);
        for (Object item:l
                ) {
            System.out.println(((Friend) item).getId2());
        }
    }

    /**
    *
    * Method: getMail(UserInfo user)
    *
    */
    @Test
    public void testGetReceiveMail() throws Exception {
    //TODO: Test goes here...
        UserInfo user =new UserInfo();
        user.setId(1);
        DatingDaoImp d=new DatingDaoImp();
        List list=d.getReceiveMail(user);
        for (Object item:list
             ) {
            System.out.println(((Mail)item).getMail());
        }
    }

    /**
    *
    * Method: getHistoryMessage(UserInfo user1, UserInfo user2)
    *
    */
    @Test
    public void testGetHistoryMessage() throws Exception {
    //TODO: Test goes here...
        UserInfo user1=new UserInfo();
        UserInfo user2=new UserInfo();
        user1.setId(1);
        user2.setId(2);
        DatingDaoImp d=new DatingDaoImp();
        List list=d.getHistoryMessage(user1,user2);
        System.out.println(list.size());
        for (Object item:list
             ) {
            System.out.println(((Mail)item).getMail());
        }
    }

    /**
    *
    * Method: sendMessage(UserInfo user1, UserInfo user2, String mail)
    *
    */
    @Test
    public void testSendMessage() throws Exception {
    //TODO: Test goes here...
        UserInfo user1=new UserInfo();
        UserInfo user2=new UserInfo();
        user1.setId(1);
        user2.setId(2);
        String mail="今天吃什么？";
        DatingDaoImp d=new DatingDaoImp();
        d.sendMessage(user1,user2,mail);
    }

    /**
    *
    * Method: updateIfRead(UserInfo user1, UserInfo user2)
    *
    */
    @Test
    public void testUpdateIfRead() throws Exception {
    //TODO: Test goes here...
        Mail m=new Mail();
        m.setId(1);
        DatingDaoImp d=new DatingDaoImp();
        d.updateIfRead(m);
    }

    /**
    *
    * Method: deleteFriend(UserInfo user, int fid)
    *
    */
    @Test
    public void testDeleteFriend() throws Exception {
    //TODO: Test goes here...
        UserInfo user1=new UserInfo();
        UserInfo user2=new UserInfo();
        user1.setId(1);
        user2.setId(2);
        DatingDaoImp d=new DatingDaoImp();
        d.deleteFriend(user1,user2.getId());

    }

    /**
     *
     * Method: removeLables(UserInfo user, int fid)
     *
     */
    @Test
    public void testRemoveLables() throws Exception {
        //TODO: Test goes here...
        DatingDaoImp d=new DatingDaoImp();
        UserInfo user=new UserInfo();
        user.setId(2);
        d.removeLables("学习;",user);
    }

} 
