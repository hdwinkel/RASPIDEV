package com.ikea.vaexabox.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.ikea.vaexabox.core.Display;

public class DisplayMapper implements ResultSetMapper<Display> {
	
	public Display map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Display(r.getString("DisplayText1"), r.getString("DisplayText2"));
	}
}
