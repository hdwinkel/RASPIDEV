package com.ikea.vaexabox;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class DWGettingStartedConfiguration extends Configuration {
    // TODO: implement service configuration
	
	@NotEmpty
	private String dburl;

	@JsonProperty
	public String getDburl() {
		return dburl;
	}
	
		
}
