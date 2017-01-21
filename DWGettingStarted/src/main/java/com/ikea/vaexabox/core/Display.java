package com.ikea.vaexabox.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Display {
	
	@JsonProperty("display1")
    public String display1;
	
	@JsonProperty("display2")
    public String display2;
	
	public Display() { }
	
	public Display(String display1, String display2){
		this.display1=display1;
		this.display2=display2;
	}
	
}
