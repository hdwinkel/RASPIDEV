package com.ikea.vaexabox.db;

import java.sql.Timestamp;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface RegistrationDAO {
	  /*
	  @SqlUpdate("create table something (id int primary key, name varchar(100))")
	  void createSomethingTable();
      
	  @SqlUpdate("insert into something (id, name) values (:id, :name)")
	  void insert(@Bind("id") int id, @Bind("name") String name);

	  @SqlQuery("select name from something where id = :id")
	  String findNameById(@Bind("id") int id);
	  */
	
	// init registration - insert
	@SqlUpdate("insert into CoWorker (DeviceID, Name, EMail, RequestID, BreakEndTime, Created, Updated, RequestAccepted) values (:deviceid, :name, :email, :requestid, :breakendtime, :created, :updated, :requestaccepted)")
	void insertInit(
			@Bind("deviceid") String deviceid, 
			@Bind("name") String name,
			@Bind("email") String email,
			@Bind("requestid") int requestid,
			@Bind("breakendtime") Timestamp breakendtime,
			@Bind("created") Timestamp created,
			@Bind("updated") Timestamp updated,
			@Bind("requestaccepted") int requestaccepted			
			);

}
