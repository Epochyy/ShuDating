package action;

import dao.*;
import entity.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class registerAction {

	private UserInfo user;
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
	public UserInfo getUser() {
		return this.user;
	}
	
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public String execute() throws Exception {
		try {
			DatingDaoImp db = new DatingDaoImp();
			int i=uploadFileName.lastIndexOf(".");//原名称里倒数第一个"."在哪里 
			String ext=uploadFileName.substring(i+1);//取得后缀，及"."后面的字符 
			uploadFileName=user.getUsername()+"."+ext;//拼凑而成 
			user.setPhoto("/images/"+uploadFileName);
			if(db.addUser(user)){
				if(upload!=null){
					
					InputStream is=new FileInputStream(getUpload());
					OutputStream os=new FileOutputStream("E:\\Tomcat9\\webapps\\ROOT\\images\\"+uploadFileName);
					OutputStream os2=new FileOutputStream("F:\\JavaEE\\dating\\src\\main\\webapp\\images\\"+uploadFileName);
					byte buffer[]=new byte[1024];   
					int count=0;

					while((count=is.read(buffer))>0){
						os.write(buffer,0,count);
						os2.write(buffer,0,count);
					}
					os.close();
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
