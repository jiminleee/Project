package com.sn.pro;

public class ProfilePost {

	int p_no;
	String p_content;
	String p_img;

	public ProfilePost() {
		// TODO Auto-generated constructor stub
	}

	public ProfilePost(int p_no, String p_content, String p_img) {
		super();
		this.p_no = p_no;
		this.p_content = p_content;
		this.p_img = p_img;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
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
