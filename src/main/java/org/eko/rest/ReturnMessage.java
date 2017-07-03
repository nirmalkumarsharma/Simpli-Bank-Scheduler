package org.eko.rest;

import javax.xml.bind.annotation.XmlRootElement;

/* Class to map the output JSON response from the application to send the message to the client */
@XmlRootElement
public class ReturnMessage {
	
	private int id;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ReturnMessage(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	public ReturnMessage() {
		super();
	}
}
