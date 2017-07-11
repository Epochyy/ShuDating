package action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import dao.DatingDaoImp;
import entity.UserInfo;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class changeuserinfo extends ActionSupport{
	private UserInfo user;
	private File upload;
	private String uploadFileName;
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public UserInfo getUser() {
		return this.user;
	}
	
	public void setUser(UserInfo user) {
		this.user = user;
	}
	//从上一页的表单得到数据存入user中，并使用此user更改数据库中id相同的user以达到更改个人信息的目的
	public String execute() throws Exception {
		// 获取content内容
		UserInfo user1=(UserInfo) ServletActionContext.getContext().getSession().get("user");
		user.setId(user1.getId());
		user.setUsername(user1.getUsername());
		int i=uploadFileName.lastIndexOf(".");//原名称里倒数第一个"."在哪里 
		String ext=uploadFileName.substring(i+1);//取得后缀，及"."后面的字符 
		uploadFileName=user.getUsername()+"."+ext;//拼凑而成 
		user.setPhoto("/images/"+uploadFileName);
		System.out.print(user.getQq());

		if(user.getSexlike()==null)
		{
			user.setSexlike("");
		}
		if(!user.getSexlike().equals(user1.getSexlike()))
		{

			DatingDaoImp a=new DatingDaoImp();
			a.alterSexLike(user.getSexlike(),user);
		}
		if(user.getPhoto()==null)
		{
			user.setPhoto("");
		}
		if(!user.getPhoto().equals(user1.getPhoto()))
		{

			DatingDaoImp a=new DatingDaoImp();
			a.alterPhoto(user.getPhoto(),user);
		}
		if(user.getQq()==null)
		{
			user.setQq("");
		}
		if(!user.getQq().equals(user1.getQq()))
		{

			DatingDaoImp a=new DatingDaoImp();
			a.alterQq(user.getQq(),user);
		}

		if(user.getLabel1()==null)
		{
			user.setLabel1("");
		}
		if(!user1.getLabel1().equals("")&&user1.getLabel1()!=null)
		//if(!user1.getLabel1().equals("")&&user1.getLabel1()!=null)
		{
			String item=user.getLabel1();
			String[] items = item.split(", ");
			DatingDaoImp a=new DatingDaoImp();
			a.alterLables(items,user);
		}
		if(user.getPhone()==null)
		{
			user.setPhone("");
		}
		if(!user.getPhone().equals(user1.getPhone()))
		{
			DatingDaoImp a=new DatingDaoImp();
			a.alterPhone(user.getPhone(),user);
		}
		if(user.getMotto()==null)
		{
			user.setMotto("");
		}
		if(!user.getMotto().equals(user1.getMotto()))
		{
			DatingDaoImp a=new DatingDaoImp();
			a.alterMotto(user.getMotto(),user);
		}
		if(user.getRequirement()==null)
		{
			user.setRequirement("");
		}
		if(!user.getRequirement().equals(user1.getRequirement()))
		{

			DatingDaoImp a=new DatingDaoImp();
			a.alterRequirement(user.getRequirement(),user);
		}

		// 调DB类中的方法判断是否插入成功
		if(user.getPhoto()!=user1.getPhoto()){
			if(upload!=null){
				InputStream is=new FileInputStream(getUpload());
				/*
				修改路径
				 */
				OutputStream os=new FileOutputStream("F:\\JavaEE\\dating\\src\\main\\webapp\\images\\"+uploadFileName);
				OutputStream os2=new FileOutputStream("E:\\Tomcat9\\webapps\\ROOT\\images\\"+uploadFileName);
				byte buffer[]=new byte[20480];
				int count=0;

				while((count=is.read(buffer))>0){
					os.write(buffer,0,count);
					os2.write(buffer,0,count);
				}
				os.close();
				os2.close();
				is.close();
	        }
		}
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		session.put("user", user);
		return SUCCESS;
	}
}
