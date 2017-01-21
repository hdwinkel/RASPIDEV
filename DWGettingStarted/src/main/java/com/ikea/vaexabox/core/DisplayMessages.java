package com.ikea.vaexabox.core;

public class DisplayMessages {

	private String initDisplay1;
	private String initDisplay2;

	private String onEventDisplay1;
	private String onEventDisplay2;

	private String onAcceptDisplay1;
	private String onAcceptDisplay2;

	
	public DisplayMessages(	String initDisplay1, 
							String initDisplay2, 
							String onEventDisplay1, 
							String onEventDisplay2, 
							String onAcceptDisplay1, 
							String onAcceptDisplay2) {

		this.initDisplay1=initDisplay1;
		this.initDisplay2=initDisplay2;
		this.onEventDisplay1=onEventDisplay1;
		this.onEventDisplay2=onEventDisplay2;
		this.onAcceptDisplay1=onAcceptDisplay1;
		this.onAcceptDisplay2=onAcceptDisplay2;
	}


	public String getInitDisplay1() {
		return initDisplay1;
	}


	public void setInitDisplay1(String initDisplay1) {
		this.initDisplay1 = initDisplay1;
	}


	public String getInitDisplay2() {
		return initDisplay2;
	}


	public void setInitDisplay2(String initDisplay2) {
		this.initDisplay2 = initDisplay2;
	}


	public String getOnEventDisplay1() {
		return onEventDisplay1;
	}


	public void setOnEventDisplay1(String onEventDisplay1) {
		this.onEventDisplay1 = onEventDisplay1;
	}


	public String getOnEventDisplay2() {
		return onEventDisplay2;
	}


	public void setOnEventDisplay2(String onEventDisplay2) {
		this.onEventDisplay2 = onEventDisplay2;
	}


	public String getOnAcceptDisplay1() {
		return onAcceptDisplay1;
	}


	public void setOnAcceptDisplay1(String onAcceptDisplay1) {
		this.onAcceptDisplay1 = onAcceptDisplay1;
	}


	public String getOnAcceptDisplay2() {
		return onAcceptDisplay2;
	}


	public void setOnAcceptDisplay2(String onAcceptDisplay2) {
		this.onAcceptDisplay2 = onAcceptDisplay2;
	}

	
}
