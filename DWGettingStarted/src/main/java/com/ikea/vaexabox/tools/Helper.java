package com.ikea.vaexabox.tools;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Helper {
	
	public static String getCurrentTimeStampAsString() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
	
	public static Timestamp getCurrentTimeStampAsTS() {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
		return sq;
	}
	
	public static Timestamp getDelayTimeStampAsTS(int minutes) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime()+(minutes*60*1000));
		return sq;
	}
	
	public static int getUUID() {
		
		
		UUID id=UUID.randomUUID();
		return id.hashCode();
		
	}
	
}
