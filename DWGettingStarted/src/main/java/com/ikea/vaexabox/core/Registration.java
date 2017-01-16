package com.ikea.vaexabox.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Registration {

	public Registration(String deviceid, String name, String email){
		this.deviceid=deviceid;
		this.name=name;
		this.email=email;
	}
	
	public Registration() { }
	
	@JsonProperty("deviceid")
    public String deviceid;
	
	@JsonProperty("name")
    public String name;
	
	@JsonProperty("email")
    public String email;
	
	
}
