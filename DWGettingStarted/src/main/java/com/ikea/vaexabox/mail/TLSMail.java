package com.ikea.vaexabox.mail;

public class TLSMail {

	private String smtphost;
	private String smtpport;
	private String smtpuser;
	private String smtppassword;

	public TLSMail(String smtphost, String smtpport, String smtpuser, String smtppassword) {

		this.smtphost = smtphost;
		this.smtpport = smtpport;
		this.smtpuser = smtpuser;
		this.smtppassword = smtppassword;
	}

	public String getSmtphost() {
		return smtphost;
	}

	public String getSmtpport() {
		return smtpport;
	}

	public String getSmtpuser() {
		return smtpuser;
	}

	public String getSmtppassword() {
		return smtppassword;
	}

}