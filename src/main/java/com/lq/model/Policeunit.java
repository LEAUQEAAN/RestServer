package com.lq.model;

import java.io.Serializable;

public class Policeunit  implements Serializable {
    
	private static final long serialVersionUID = 1L;
	private String policeunit_code ;
	private String    policeunit_name;
	
	public Policeunit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Policeunit(String policeunit_code, String policeunit_name) {
		super();
		this.policeunit_code = policeunit_code;
		this.policeunit_name = policeunit_name;
	}
	public String getPoliceunit_code() {
		return policeunit_code;
	}
	public void setPoliceunit_code(String policeunit_code) {
		this.policeunit_code = policeunit_code;
	}
	public String getPoliceunit_name() {
		return policeunit_name;
	}
	public void setPoliceunit_name(String policeunit_name) {
		this.policeunit_name = policeunit_name;
	}
	
	@Override
	public String toString() {
		return "Policeunit [policeunit_code=" + policeunit_code
				+ ", policeunit_name=" + policeunit_name + "]";
	} 
}
