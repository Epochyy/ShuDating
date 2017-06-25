package action;

import java.sql.*;
import java.util.*;
import model.*;

import db.DB;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class registerAction {

	private User user;
	private File upload;
	private String uploadFileName;
	private String uploadContentType; 
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
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
	/*public void validate() { //手工方式验证登录的时候用户名密码是否是空
		if (user.getUsername() == null || user.getUsername().trim().equals("")) {
			addFieldError("user.username", "请输入用户名");
		}
		if (user.getPassword() == null ||user.getPassword().trim().equals("")) {
			addFieldError("user.password", "请输入密码");
		}
   }*/
	public String execute() throws Exception {
		try {
			DB db = new DB();
			int i=uploadFileName.lastIndexOf(".");//原名称里倒数第一个"."在哪里 
			String ext=uploadFileName.substring(i+1);//取得后缀，及"."后面的字符 
			uploadFileName=user.getUsername()+"."+ext;//拼凑而成 
			user.setPhoto("images/"+uploadFileName);
			if(db.register(user)){
				System.out.println("我倒这里了");
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
					return "success";
		        }
				return "error";
			}
			return "error";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
		
	
	}
	
}
