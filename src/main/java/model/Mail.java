package model;

import java.sql.Timestamp;
public class Mail {
	private int id;
	private int sender;
	private int receiver;
	private Timestamp time;
	private String mail;
	private int ifread;
	public int getIfread() {
		return ifread;
	}
	public void setIfread(int ifread) {
		this.ifread = ifread;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
