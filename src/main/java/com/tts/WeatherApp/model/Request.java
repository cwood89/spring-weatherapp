package com.tts.WeatherApp.model;

public class Request {
	
	private String zipCode;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Request(String zipCode) {
		super();
		this.zipCode = zipCode;
	} 	
	
	public Request() {
		
	}
	
}
