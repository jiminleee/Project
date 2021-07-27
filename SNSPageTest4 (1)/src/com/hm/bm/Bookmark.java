package com.hm.bm;

public class Bookmark {
	private int b_no;
	private String b_id;
	private String b_content;
	private String b_img;
	
	public Bookmark() {
		// TODO Auto-generated constructor stub
	}

	public Bookmark(int b_no, String b_id, String b_content, String b_img) {
		super();
		this.b_no = b_no;
		this.b_id = b_id;
		this.b_content = b_content;
		this.b_img = b_img;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_img() {
		return b_img;
	}

	public void setB_img(String b_img) {
		this.b_img = b_img;
	}
	
	
	
}
