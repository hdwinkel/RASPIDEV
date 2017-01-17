package com.ikea.vaexabox.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Break {
	
	@JsonProperty("deviceid")
    public String deviceid;
	
	@JsonProperty("minutes")
    public int minutes;
	
}
