package com.ikea.vaexabox.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {

	@JsonProperty("name")
    public String name;
	
	@JsonProperty("type")
    public String type;
	
	@JsonProperty("count")
    public int count;
	
		
}
