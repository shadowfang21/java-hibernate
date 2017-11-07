package com.sf.learning.toolman.model;

import java.io.Serializable;

public class Master implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long masterId;
	
	private String name;
	
	private String address;

	public long getMasterId() {
		return masterId;
	}

	public void setMasterId(long masterId) {
		this.masterId = masterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
