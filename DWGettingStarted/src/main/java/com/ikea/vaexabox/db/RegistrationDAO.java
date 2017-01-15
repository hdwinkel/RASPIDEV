package com.ikea.vaexabox.db;

import java.sql.Timestamp;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
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
	
	// init co-worker registration - insert
	@SqlUpdate("insert into CoWorker (DeviceID, Name, EMail, RequestID, BreakEndTime, Created, Updated) values (:deviceid, :name, :email, :requestid, :breakendtime, :created, :updated)")
	void initRegistration(
			@Bind("deviceid") String deviceid, 
			@Bind("name") String name,
			@Bind("email") String email,
			@Bind("requestid") int requestid,
			@Bind("breakendtime") Timestamp breakendtime,
			@Bind("created") Timestamp created,
			@Bind("updated") Timestamp updated			
			);

	// update co-worker registration - update
	@SqlUpdate("update CoWorker set DeviceID = :deviceid, Name = :name, EMail = :email, RequestID = :requestid, BreakEndTime = :breakendtime, Created = :created, Updated = :updated where DeviceID = :deviceid")
	void updateRegistration(
			@Bind("deviceid") String deviceid, 
			@Bind("name") String name,
			@Bind("email") String email,
			@Bind("requestid") int requestid,
			@Bind("breakendtime") Timestamp breakendtime,
			@Bind("created") Timestamp created,
			@Bind("updated") Timestamp updated			
			);
	
	
	// update co-worker registration - update
	@SqlUpdate("update CoWorker set BreakEndTime = :breakendtime, Updated = :updated where DeviceID = :deviceid")
	void updateBreakEndTime(
			@Bind("deviceid") String deviceid, 
			@Bind("breakendtime") Timestamp breakendtime,
			@Bind("updated") Timestamp updated			
			);
		
	
	// count registrations for a specific device
	@SqlQuery("select Count(*) from CoWorker where DeviceID = :deviceid")
	int getCountOfRegistrationsForDeviceID(
			@Bind("deviceid") String deviceid 
			);
	
	
	
	
}
