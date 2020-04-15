package com.xiangcai.pojo;

import java.util.Date;

public class Test {
	private int id;
	private Date time;
	
	public Test() {
		super();
	}
	public Test(Date time) {
		super();
		this.time = time;
	}
	public Test(int id, Date time) {
		super();
		this.id = id;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
