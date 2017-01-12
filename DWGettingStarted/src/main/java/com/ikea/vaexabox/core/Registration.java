package com.ikea.vaexabox.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Registration {

	@JsonProperty("deviceid")
    public String deviceid;
	
	@JsonProperty("name")
    public String name;
	
	@JsonProperty("email")
    public String email;
	
	
}
