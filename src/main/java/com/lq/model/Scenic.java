package com.lq.model;

import java.io.Serializable;

public class Scenic  implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private String scenic_code;
	private String  policeunit_code;
	private String  scenic_name;
	 
	public Scenic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Scenic(String scenic_code, String policeunit_code, String scenic_name) {
		super();
		this.scenic_code = scenic_code;
		this.policeunit_code = policeunit_code;
		this.scenic_name = scenic_name;
	}
	public String getScenic_code() {
		return scenic_code;
	}
	public void setScenic_code(String scenic_code) {
		this.scenic_code = scenic_code;
	}
	public String getPoliceunit_code() {
		return policeunit_code;
	}
	public void setPoliceunit_code(String policeunit_code) {
		this.policeunit_code = policeunit_code;
	}
	public String getScenic_name() {
		return scenic_name;
	}
	public void setScenic_name(String scenic_name) {
		this.scenic_name = scenic_name;
	}
	@Override
	public String toString() {
		return "Scenic [scenic_code=" + scenic_code + ", policeunit_code="
				+ policeunit_code + ", scenic_name=" + scenic_name + "]";
	}
}
