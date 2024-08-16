package com;
	// 객체 만들기
public class MemberVO {
	private String name;
	private String phone;
		
	// 생성자 만들기
	public MemberVO(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	//2.private이라 접근 불가능하니 public으로 가져오기. getter, setter 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
