package org.eko.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InputJsonSimpliJobDS{
	
	private int id;
	private int status;

	public InputJsonSimpliJobDS() {
		super();
	}
	public InputJsonSimpliJobDS(int id, int status) {
		super();
		this.id = id;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
