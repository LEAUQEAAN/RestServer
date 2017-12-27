package com.lq.model;

import java.io.Serializable;

public class Recmsg  implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	private String recmsg_code;
	private String police_code;
	private String message_code;
	private String recmsg_status;
	private String recmsg_wkstatus;


	public Recmsg(String recmsg_code, String police_code, String message_code, String recmsg_status, String recmsg_wkstatus) {
		this.recmsg_code = recmsg_code;
		this.police_code = police_code;
		this.message_code = message_code;
		this.recmsg_status = recmsg_status;
		this.recmsg_wkstatus = recmsg_wkstatus;
	}

	public Recmsg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRecmsg_wkstatus() {return recmsg_wkstatus;}
	public void setRecmsg_wkstatus(String recmsg_wkstatus) {this.recmsg_wkstatus = recmsg_wkstatus;}
	public String getRecmsg_status() {return recmsg_status;}
	public void setRecmsg_status(String recmsg_status) {this.recmsg_status = recmsg_status;}
	public String getRecmsg_code() {
		return recmsg_code;
	}
	public void setRecmsg_code(String recmsg_code) {
		this.recmsg_code = recmsg_code;
	}
	public String getPolice_code() {
		return police_code;
	}
	public void setPolice_code(String police_code) {
		this.police_code = police_code;
	}
	public String getMessage_code() {
		return message_code;
	}
	public void setMessage_code(String message_code) {
		this.message_code = message_code;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Recmsg{" +
				"recmsg_code='" + recmsg_code + '\'' +
				", police_code='" + police_code + '\'' +
				", message_code='" + message_code + '\'' +
				", recmsg_status='" + recmsg_status + '\'' +
				", recmsg_wkstatus='" + recmsg_wkstatus + '\'' +
				'}';
	}
}
