package com.jm.login;

public class Post {
	
	private int p_no;
	private String p_id;
	private String p_content;
	private String p_img;
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(int p_no, String p_id, String p_content, String p_img) {
		super();
		this.p_no = p_no;
		this.p_id = p_id;
		this.p_content = p_content;
		this.p_img = p_img;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}
	
	
	
	
}
