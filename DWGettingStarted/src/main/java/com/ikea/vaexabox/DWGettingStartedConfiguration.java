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
	
	@NotEmpty
	private String initDisplay1;
	@NotEmpty
	private String initDisplay2;
	@NotEmpty
	private String onEventDisplay1;
	@NotEmpty
	private String onEventDisplay2;
	@NotEmpty
	private String onAcceptDisplay1;
	@NotEmpty
	private String onAcceptDisplay2;

	@JsonProperty
	public String getInitDisplay1() {
		return initDisplay1;
	}

	@JsonProperty
	public String getInitDisplay2() {
		return initDisplay2;
	}

	@JsonProperty
	public String getOnEventDisplay1() {
		return onEventDisplay1;
	}

	@JsonProperty
	public String getOnEventDisplay2() {
		return onEventDisplay2;
	}

	@JsonProperty
	public String getOnAcceptDisplay1() {
		return onAcceptDisplay1;
	}

	@JsonProperty
	public String getOnAcceptDisplay2() {
		return onAcceptDisplay2;
	}
	
	
}
