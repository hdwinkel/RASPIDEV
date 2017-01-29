package com.ikea.vaexabox.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Manned {
	
	@JsonProperty("deviceid")
    public String deviceid;
	
	@JsonProperty("ismanned")
    public int ismanned;
	
}
