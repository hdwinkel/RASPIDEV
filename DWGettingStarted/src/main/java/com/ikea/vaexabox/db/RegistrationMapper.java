package com.ikea.vaexabox.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.ikea.vaexabox.core.Registration;

public class RegistrationMapper implements ResultSetMapper<Registration> {
	
	public Registration map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Registration(r.getString("DeviceID"), r.getString("Name"), r.getString("EMail"));
	}
}
