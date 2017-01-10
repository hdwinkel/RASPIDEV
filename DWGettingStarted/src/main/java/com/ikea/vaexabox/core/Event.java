package com.ikea.vaexabox.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {

	@JsonProperty("id")
    public String id;
	
	@JsonProperty("number")
    public int number;
	
	@JsonProperty("type")
    public String type;
	
}
