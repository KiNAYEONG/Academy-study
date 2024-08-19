package com.model;

public class WMemberVO {
	private String id;
	private String pw;
	private String nick;
	
	public WMemberVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	//VO(클래스) 객체 반드시 3개의 데이터가 들어가도록 생성자 만들기	
	public WMemberVO(String id, String pw, String nick) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}

}
