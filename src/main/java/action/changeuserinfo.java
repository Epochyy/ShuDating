package action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import model.*;
import db.DB;
public class changeuserinfo {
	private User user;
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
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	//从上一页的表单得到数据存入user中，并使用此user更改数据库中id相同的user以达到更改个人信息的目的
	public String execute() throws Exception {
		// 获取content内容
		User user1=(User) ServletActionContext.getContext().getSession().get("user");
		user.setId(user1.getId());
		user.setUsername(user1.getUsername());
		user.setPassword(user1.getPassword());
		user.setAge(user1.getAge());
		user.setGender(user1.getGender());
		user.setRealname(user1.getRealname());
		int i=uploadFileName.lastIndexOf(".");//原名称里倒数第一个"."在哪里 
		String ext=uploadFileName.substring(i+1);//取得后缀，及"."后面的字符 
		uploadFileName=user.getUsername()+"."+ext;//拼凑而成 
		user.setPhoto("images/"+uploadFileName);
		System.out.print(user.getQq());
		
		// 调DB类中的方法判断是否插入成功
		if(new DB().changeuserInfo(user)){
			if(upload!=null){
				InputStream is=new FileInputStream(getUpload());  	//����ϴ����ļ��õ�������
				OutputStream os=new FileOutputStream("C:\\Users\\cpp\\Workspaces\\MyEclipse 10\\Dating\\WebRoot\\images\\"+uploadFileName);  //ָ���������ַ
				OutputStream os2=new FileOutputStream("C:\\apache-tomcat-7.0.76\\webapps\\Dating\\images\\"+uploadFileName);
				byte buffer[]=new byte[1024];   
				int count=0;
				while((count=is.read(buffer))>0){
					os.write(buffer,0,count);    			  		//���ļ�д��ָ��λ�õ��ļ���
					os2.write(buffer,0,count);
				}
				os.close();                    			   		//�ر�
				os2.close();
				is.close();
				ActionContext context = ActionContext.getContext();
				Map session = context.getSession();
				session.put("user", user);
				return "success";
	        }	
			return "error";
		}
		else{
			return "error";
		}
	}
}
