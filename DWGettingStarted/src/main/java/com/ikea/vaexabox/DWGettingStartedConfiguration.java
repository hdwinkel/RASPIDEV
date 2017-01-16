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
	
	@NotEmpty
	private String raspi;

	@JsonProperty
	public String getRaspi() {
		return raspi;
	}
	
	@NotEmpty
	private String smtphost;
	
	@NotEmpty
	private String smtpport;
	
	@NotEmpty
	private String smtpuser;
	
	@NotEmpty
	private String smtppassword;

	@JsonProperty
	public String getSmtphost() {
		return smtphost;
	}

	@JsonProperty
	public String getSmtpport() {
		return smtpport;
	}

	@JsonProperty
	public String getSmtpuser() {
		return smtpuser;
	}

	@JsonProperty
	public String getSmtppassword() {
		return smtppassword;
	}
	
	@NotEmpty
	private String sendmail;

	@JsonProperty
	public String getSendmail() {
		return sendmail;
	}
	
}
