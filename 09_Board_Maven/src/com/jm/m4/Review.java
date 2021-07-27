package com.jm.m4;

import java.util.Date;

public class Review {
	private int r_no; 
	private String r_title; 
	private String r_txt; 
	private Date r_date;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int r_no, String r_title, String r_txt, Date r_date) {
		super();
		this.r_no = r_no;
		this.r_title = r_title;
		this.r_txt = r_txt;
		this.r_date = r_date;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_txt() {
		return r_txt;
	}

	public void setR_txt(String r_txt) {
		this.r_txt = r_txt;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	
	
}
