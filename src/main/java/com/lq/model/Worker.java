package com.lq.model;

import java.io.Serializable;

public class Worker  implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	private String    worker_code;
	private String    scenic_code;
	private String    worker_serviceid;
	private String    worker_name;
	private String    worker_sex;
	private String    worker_phone;
	private String    worker_pwd;
	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Worker(String worker_code, String scenic_code,
			String worker_serviceid, String worker_name, String worker_sex,
			String worker_phone, String worker_pwd) {
		super();
		this.worker_code = worker_code;
		this.scenic_code = scenic_code;
		this.worker_serviceid = worker_serviceid;
		this.worker_name = worker_name;
		this.worker_sex = worker_sex;
		this.worker_phone = worker_phone;
		this.worker_pwd = worker_pwd;
	}
	public String getWorker_code() {
		return worker_code;
	}
	public void setWorker_code(String worker_code) {
		this.worker_code = worker_code;
	}
	public String getScenic_code() {
		return scenic_code;
	}
	public void setScenic_code(String scenic_code) {
		this.scenic_code = scenic_code;
	}
	public String getWorker_serviceid() {
		return worker_serviceid;
	}
	public void setWorker_serviceid(String worker_serviceid) {
		this.worker_serviceid = worker_serviceid;
	}
	public String getWorker_name() {
		return worker_name;
	}
	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}
	public String getWorker_sex() {
		return worker_sex;
	}
	public void setWorker_sex(String worker_sex) {
		this.worker_sex = worker_sex;
	}
	public String getWorker_phone() {
		return worker_phone;
	}
	public void setWorker_phone(String worker_phone) {
		this.worker_phone = worker_phone;
	}
	public String getWorker_pwd() {
		return worker_pwd;
	}
	public void setWorker_pwd(String worker_pwd) {
		this.worker_pwd = worker_pwd;
	}
	@Override
	public String toString() {
		return "Worker [worker_code=" + worker_code + ", scenic_code="
				+ scenic_code + ", worker_serviceid=" + worker_serviceid
				+ ", worker_name=" + worker_name + ", worker_sex=" + worker_sex
				+ ", worker_phone=" + worker_phone + ", worker_pwd="
				+ worker_pwd + "]";
	}
}
