package com.ikea.vaexabox.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Count {
	
	@JsonProperty("count")
    public int count;
	
	@JsonProperty("location")
    public String location;
}
