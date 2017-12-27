package com.lq.model;

import java.io.Serializable;

public class Info implements Serializable {

	String Text;

	public Info(String Text) {
		super();
		this.Text = Text;
	}

	@Override
	public String toString() {
		return "Info{" +
				"Text='" + Text + '\'' +
				'}';
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}
}
