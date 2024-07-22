package com.aischool.model;

//WebMember클래스는 데이터베이스의 정보를 저장할 데이터 타입
//테이블: WEB_MEMBER
//컬럼명: EMAIL, PW, TEL, ADDRESS
//데이터타입: VARCHAR2 4개가 동일하니 한번만 씀

//위 정보를 Java에서 표현할 수 있게 클래스 생성
//WEB_MEMBER -> WebMember 클래스
//EMAIL, PW, TEL, ADDRESS -> 필드변수
//VARCHAR2 -> String

//alt+shift+s 1생성자, 2겟터셋터생성
//추가적으로 생성자(기본&사용자정의), Getter&Setter 메소드 생성
public class WebMember {
	private String email;
	private String pw;
	private String tel;
	private String address;
	
	public WebMember() {}
	
	public WebMember(String email, String pw, String tel, String address) {
		super();
		this.email = email;
		this.pw = pw;
		this.tel = tel;
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
