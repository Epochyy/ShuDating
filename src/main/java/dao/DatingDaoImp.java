package dao;

import entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sessionfactory.HibernateSessionFactory;
import org.hibernate.Query;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: DatingDaoImp
 * @Description: Dao�ࡪ���̳�Dao�ӿ�
 * @Author: ����
 * @Date: 2017/6/24.
 */
public class DatingDaoImp implements DatingDao{

    @Override
    public UserInfo getUserById(int id) {
        UserInfo user = null;
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = session.beginTransaction();
        Query query = session.createQuery("from UserInfo as u where u.id=:uid");
        query.setInteger("uid", id);
        user = (UserInfo) query.uniqueResult();
        ts.commit();
        HibernateSessionFactory.closeSession();
        return user;
    }

    @Override
    public UserInfo getUserByName(String username) {
        UserInfo user = null;
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = session.beginTransaction();
        Query query = session.createQuery("from UserInfo as u where u.username=:username");
        query.setString("username", username);
        user = (UserInfo) query.uniqueResult();
        ts.commit();
        HibernateSessionFactory.closeSession();
        return user;
    }

    //����û�ʱͬʱ��������Ϣ��ע��ʱֱ�ӵ��øú���
    @Override
    public boolean addUser(UserInfo userInfo) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        try{
            ts = session.beginTransaction();
            userInfo.setPassword(userInfo.getPassword());
            userInfo.setRealname(userInfo.getRealname());
            userInfo.setGender(userInfo.getGender());
            userInfo.setAge(userInfo.getAge());
            userInfo.setSexlike(userInfo.getSexlike());
            userInfo.setPhone(userInfo.getPhoto());
            userInfo.setPhoto(userInfo.getPhoto());
            session.save(userInfo);
            ts.commit();
        } catch(Exception e) {
            flag=false;
            if(ts!=null)
                ts.rollback();
            System.out.println("����û�ʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean alterRealName(String username,UserInfo user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("update UserInfo u set u.realname=:newName where u.id=:uid");
            query.setString("newName", username);
            query.setInteger("uid", user.getId());
            query.executeUpdate();
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            flag=false;
            System.out.println("�޸��û���ʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean alterGender(String gender,UserInfo user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("update UserInfo u set u.gender=:newGender where u.id=:uid");
            query.setString("newGender", gender);
            query.setInteger("uid", user.getId());
            query.executeUpdate();
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            flag=false;
            System.out.println("�޸��Ա�ʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean alterPassword(String password,UserInfo user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("update UserInfo u set u.password=:newPwd where u.id=:uid");
            query.setString("newPwd", password);
            query.setInteger("uid", user.getId());
            query.executeUpdate();
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            flag=false;
            System.out.println("�޸�����ʧ��!");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean alterAge(int age,UserInfo user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("update UserInfo u set u.age=:newAge where u.id=:uid");
            query.setInteger("newAge", age);
            query.setInteger("uid", user.getId());
            query.executeUpdate();
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            flag=false;
            System.out.println("�޸�����ʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean alterSexLike(String sexlike,UserInfo user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("update UserInfo u set u.sexlike=:newSexlike where u.id=:uid");
            query.setString("newSexlike", sexlike);
            query.setInteger("uid", user.getId());
            query.executeUpdate();
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            flag=false;
            System.out.println("�޸���ȡ��ʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean alterPhoto(String photo,UserInfo user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("update UserInfo u set u.photo=:newPhoto where u.id=:uid");
            query.setString("newPhoto", photo);
            query.setInteger("uid", user.getId());
            query.executeUpdate();
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            flag=false;
            System.out.println("�ϴ�ͷ��ʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean alterQq(String qq,UserInfo user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("update UserInfo u set u.qq=:newQq where u.id=:uid");
            query.setString("newQq", qq);
            query.setInteger("uid", user.getId());
            query.executeUpdate();
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            flag=false;
            System.out.println("�޸�QQʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean alterPhone(String phone,UserInfo user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("update UserInfo u set u.phone=:newPhone where u.id=:uid");
            query.setString("newPhone", phone);
            query.setInteger("uid", user.getId());
            query.executeUpdate();
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            flag=false;
            System.out.println("�޸�phoneʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean alterMotto(String motto,UserInfo user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("update UserInfo u set u.motto=:newMotto where u.id=:uid");
            query.setString("newMotto", motto);
            query.setInteger("uid", user.getId());
            query.executeUpdate();
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            flag=false;
            System.out.println("�޸�mottoʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean alterRequirement(String requirement,UserInfo user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("update UserInfo u set u.requirement=:newRequirement where u.id=:uid");
            query.setString("newRequirement", requirement);
            query.setInteger("uid", user.getId());
            query.executeUpdate();
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            flag=false;
            System.out.println("�޸�requirementʧ��!");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean alterLables(String[] labels,UserInfo user) {
        UserInfo u=null;
        u=getUserById(user.getId());
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        int s=labels.length;
        String Labels="";
        if(u.getLabel1()!=null) {
            Labels += u.getLabel1();
        }
        for(int i=0;i<s;i++) {
            Labels+=labels[i]+";";
        }
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("update UserInfo u set u.label1=:newLabel where u.id=:uid");
            query.setString("newLabel", Labels);
            query.setInteger("uid", user.getId());
            query.executeUpdate();
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            flag=false;
            System.out.println("�޸ı�ǩʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean addNews(UserInfo user, String news) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        News n=new News();
        n.setNews(news);
        n.setTime(new Timestamp(System.currentTimeMillis()));
        n.setUid(user.getId());
        n.setUsername(user.getUsername());
        try{
            ts = session.beginTransaction();
            session.save(n);
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            System.out.println("�������ʧ�ܣ�");
            flag=false;
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public List getMyNews(UserInfo user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = session.beginTransaction();
        List list = null;
        Query query = session.createQuery("from News as n where n.uid=:userid order by time desc");
        query.setInteger("userid", user.getId());
        list = query.list();
        ts.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }

    @Override
    public List getFirendsNews(UserInfo user) {
        List<Friend> l=getAllFriend(user);
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = session.beginTransaction();
        ArrayList<News> list = new ArrayList();
        for (int i=0;i<l.size();i++) {
            Query query = session.createQuery("from News as n where n.uid=:userid order by time desc");
            query.setInteger("userid", l.get(i).getId2());
            List le=query.list();
            for (Object item:le ) {
                list.add((News) item);
            }
        }
        ts.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }

    @Override
    public List getLatestNews() {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = session.beginTransaction();
        Query query = session.createQuery("from LoveWall as n order by n.id desc");
        query.setMaxResults(4);
        List list=query.list();
        ts.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }

    @Override
    public UserInfo getFriendPage(UserInfo friend) {
        UserInfo user = null;
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = session.beginTransaction();
        Query query = session.createQuery("from UserInfo as u where u.id=:uid");
        query.setInteger("uid", friend.getId());
        user = (UserInfo) query.uniqueResult();
        ts.commit();
        HibernateSessionFactory.closeSession();
        return user;
    }

    @Override
    public List searchUser(String myname,String[] regx) {
        List list=null;
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = session.beginTransaction();
        Query query = session.createQuery("from UserInfo as u");
        list = query.list();
        ArrayList<UserInfo> users=new ArrayList<>();
        Map<UserInfo,Integer> matchDegree=new HashMap<>();
        for (Object item: list
             ) {
            UserInfo u=(UserInfo)item;
            int match=0;
            for(int i=0;i<regx.length;i++) {
               // System.out.println(u.getUsername());
                if(u.getLabel1()!=null) {
                    int index = u.getLabel1().indexOf(regx[i]);
                    if (index != -1) {
                        match += 1;
                    }
                }
            }
            if(match!=0){
                matchDegree.put(u,match);
            }
        }
        matchDegree=mapsort.sortMap(matchDegree);
        for (UserInfo key:matchDegree.keySet()
             ) {
            if(key.getUsername().equals(myname)){
                continue;
            }
            users.add(key);
        }
        ts.commit();
        HibernateSessionFactory.closeSession();
        return users;
    }

    @Override
    public boolean addLoveWall(UserInfo user, String text) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        LoveWall n=new LoveWall();
        n.setText(text);
        n.setTime(new Timestamp(System.currentTimeMillis()));
        n.setUid(user.getId());
        n.setUsername(user.getUsername());
        try{
            ts = session.beginTransaction();
            session.save(n);
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            System.out.println("���ʧ�ܣ�");
            flag=false;
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean addFriend(UserInfo user,int fid) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        Friend f=new Friend();
        f.setId1(user.getId());
        f.setId2(fid);
        Friend f1=new Friend();
        f1.setId2(user.getId());
        f1.setId1(fid);
        boolean flag=true;
        try{
            ts = session.beginTransaction();
            session.save(f);
            session.save(f1);
            ts.commit();
        } catch(Exception e) {
            flag=false;
            if(ts!=null)
                ts.rollback();
            System.out.println("����û�ʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public List getAllFriend(UserInfo user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = session.beginTransaction();
        List list = null;
        Query query = session.createQuery("from Friend as f where f.id1=:myid");
        query.setInteger("myid", user.getId());
        list = query.list();
        ts.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }

    @Override
    public List getReceiveMail(UserInfo user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = session.beginTransaction();
        List list = null;
        Query query = session.createQuery("from Mail as m where m.receiver=:myid order by m.receiver");
        query.setInteger("myid", user.getId());
        list = query.list();
        ts.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }

    @Override
    public List getHistoryMessage(UserInfo user1, UserInfo user2) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = session.beginTransaction();
        List list = null;
        Query query = session.createQuery("from Mail as m where (m.receiver=:myid and m.sender=:uid) or (m.receiver=:uid and m.sender=:myid) order by m.time");
        query.setInteger("myid", user1.getId());
        query.setInteger("uid", user2.getId());
        list = query.list();
        ts.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }

    @Override
    public boolean sendMessage(UserInfo user1, UserInfo user2, String mail) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        Mail m=new Mail();
        m.setSender(user1.getId());
        m.setReceiver(user2.getId());
        m.setMail(mail);
        m.setTime(new Timestamp(System.currentTimeMillis()));
        m.setIfread(0);
        boolean flag=true;
        try{
            ts = session.beginTransaction();
            session.save(m);
            ts.commit();
        } catch(Exception e) {
            flag=false;
            if(ts!=null)
                ts.rollback();
            System.out.println("������Ϣʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    //�޸Ĵ��ݲ���mailΪuser1 user2�Լ���Ӧhql���
    @Override
    public boolean updateIfRead(UserInfo user1, UserInfo user2) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("update Mail m set m.ifread=1 where m.sender=:sid and m.receiver=:rid");
            query.setInteger("sid", user1.getId());
            query.setInteger("rid", user2.getId());
            query.executeUpdate();
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            flag=false;
            System.out.println("�޸���Ϣ״̬ʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean deleteFriend(UserInfo user, int fid) {
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("delete Friend f where f.id1=:myid and f.id2=:fid");
            query.setInteger("myid", user.getId());
            query.setInteger("fid", fid);
            query.executeUpdate();
            Query query2 = session.createQuery("delete Friend f where f.id1=:myid and f.id2=:fid");
            query2.setInteger("myid", fid);
            query2.setInteger("fid", user.getId());
            query2.executeUpdate();
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            flag=false;
            System.out.println("ɾ������ʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }

    @Override
    public boolean removeLables(String label, UserInfo user) {
        UserInfo u=getUserById(user.getId());
        String labels=u.getLabel1();
        labels=labels.replaceAll(label,"");
        Session session = HibernateSessionFactory.getSession();
        Transaction ts = null;
        boolean flag=true;
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("update UserInfo u set u.label1=:newLabels where u.id=:uid");
            query.setString("newLabels", labels);
            query.setInteger("uid", user.getId());
            query.executeUpdate();
            ts.commit();
        } catch(Exception e) {
            if(ts!=null)
                ts.rollback();
            flag=false;
            System.out.println("�޸ı�ǩʧ�ܣ�");
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return flag;
    }
}
