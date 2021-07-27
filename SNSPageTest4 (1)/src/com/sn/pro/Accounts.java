package com.sn.pro;

public class Accounts {
	private String a_id;
	private String a_pw;
	private String a_name;
	private String a_birth;
	private String a_gender;
	private String a_intro;
	private String a_img;
	
	public Accounts() {
		// TODO Auto-generated constructor stub
	}

	public Accounts(String a_id, String a_pw, String a_name, String a_birth, String a_gender, String a_intro,
			String a_img) {
		super();
		this.a_id = a_id;
		this.a_pw = a_pw;
		this.a_name = a_name;
		this.a_birth = a_birth;
		this.a_gender = a_gender;
		this.a_intro = a_intro;
		this.a_img = a_img;
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getA_pw() {
		return a_pw;
	}

	public void setA_pw(String a_pw) {
		this.a_pw = a_pw;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getA_birth() {
		return a_birth;
	}

	public void setA_birth(String a_birth) {
		this.a_birth = a_birth;
	}

	public String getA_gender() {
		return a_gender;
	}

	public void setA_gender(String a_gender) {
		this.a_gender = a_gender;
	}

	public String getA_intro() {
		return a_intro;
	}

	public void setA_intro(String a_intro) {
		this.a_intro = a_intro;
	}

	public String getA_img() {
		return a_img;
	}

	public void setA_img(String a_img) {
		this.a_img = a_img;
	}

	
	
	
}