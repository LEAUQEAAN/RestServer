package com.lq.model;

import java.io.Serializable;

public class Police  implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private String  police_code;
	private String  policeunit_code;
	private String  police_serviceid;
	private String  police_name;
	private String  police_sex;
	private String  police_phone;
	private String  police_pwd;
	public Police() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Police(String police_code, String policeunit_code,
			String police_serviceid, String police_name, String police_sex,
			String police_phone, String police_pwd) {
		super();
		this.police_code = police_code;
		this.policeunit_code = policeunit_code;
		this.police_serviceid = police_serviceid;
		this.police_name = police_name;
		this.police_sex = police_sex;
		this.police_phone = police_phone;
		this.police_pwd = police_pwd;
	}
	public String getPolice_code() {
		return police_code;
	}
	public void setPolice_code(String police_code) {
		this.police_code = police_code;
	}
	public String getPoliceunit_code() {
		return policeunit_code;
	}
	public void setPoliceunit_code(String policeunit_code) {
		this.policeunit_code = policeunit_code;
	}
	public String getPolice_serviceid() {
		return police_serviceid;
	}
	public void setPolice_serviceid(String police_serviceid) {
		this.police_serviceid = police_serviceid;
	}
	public String getPolice_name() {
		return police_name;
	}
	public void setPolice_name(String police_name) {
		this.police_name = police_name;
	}
	public String getPolice_sex() {
		return police_sex;
	}
	public void setPolice_sex(String police_sex) {
		this.police_sex = police_sex;
	}
	public String getPolice_phone() {
		return police_phone;
	}
	public void setPolice_phone(String police_phone) {
		this.police_phone = police_phone;
	}
	public String getPolice_pwd() {
		return police_pwd;
	}
	public void setPolice_pwd(String police_pwd) {
		this.police_pwd = police_pwd;
	}
	@Override
	public String toString() {
		return "Police [police_code=" + police_code + ", policeunit_code="
				+ policeunit_code + ", police_serviceid=" + police_serviceid
				+ ", police_name=" + police_name + ", police_sex=" + police_sex
				+ ", police_phone=" + police_phone + ", police_pwd="
				+ police_pwd + "]";
	}
}
