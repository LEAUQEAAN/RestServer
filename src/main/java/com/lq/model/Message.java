package com.lq.model;

import java.io.Serializable;

public class Message implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	private String   message_code;
	private String   worker_code;
	private String   message_time;
	private String   message_note;
	private String   message_status;
	private String   message_lo;
	private String   message_al;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String message_code, String worker_code, String message_time,
				   String message_note, String message_status,
				   String message_lo, String message_al) {
		this.message_code = message_code;
		this.worker_code = worker_code;
		this.message_time = message_time;
		this.message_note = message_note;
		this.message_status = message_status;
		this.message_lo = message_lo;
		this.message_al = message_al;
	}

	public String getMessage_code() {
		return message_code;
	}
	public void setMessage_code(String message_code) {
		this.message_code = message_code;
	}
	public String getWorker_code() {
		return worker_code;
	}
	public void setWorker_code(String worker_code) {
		this.worker_code = worker_code;
	}
	public String getMessage_time() {
		return message_time;
	}
	public void setMessage_time(String message_time) {
		this.message_time = message_time;
	}
	public String getMessage_note() {
		return message_note;
	}
	public void setMessage_note(String message_note) {
		this.message_note = message_note;
	}
	public String getMessage_status() {
		return message_status;
	}
	public void setMessage_status(String message_status) {
		this.message_status = message_status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getMessage_lo() {	return message_lo;}
	public void setMessage_lo(String message_lo) {	this.message_lo = message_lo;}
	public String getMessage_al() {	return message_al;}
	public void setMessage_al(String message_al) {	this.message_al = message_al;}

	@Override
	public String toString() {
		return "Message{" +
				"message_code='" + message_code + '\'' +
				", worker_code='" + worker_code + '\'' +
				", message_time='" + message_time + '\'' +
				", message_note='" + message_note + '\'' +
				", message_status='" + message_status + '\'' +
				", message_lo='" + message_lo + '\'' +
				", message_al='" + message_al + '\'' +
				'}';
	}
}
