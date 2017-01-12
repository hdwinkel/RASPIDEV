package com.ikea.vaexabox.db;

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
	
	public static Timestamp get8hTimeStampAsTS() {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime()+(8*60*60*1000));
		return sq;
	}
	
	public static int getID() {
		
		
		UUID id=UUID.randomUUID();
		return id.hashCode();
		
	}
	
}
