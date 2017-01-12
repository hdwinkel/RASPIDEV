package com.ikea.vaexabox.db;

import java.sql.Timestamp;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface EventDAO {
	  /*
	  @SqlUpdate("create table something (id int primary key, name varchar(100))")
	  void createSomethingTable();
      
	  @SqlUpdate("insert into something (id, name) values (:id, :name)")
	  void insert(@Bind("id") int id, @Bind("name") String name);

	  @SqlQuery("select name from something where id = :id")
	  String findNameById(@Bind("id") int id);
	  */
	  
	@SqlUpdate("insert into HelpRequest (RequestID, RequestType, Created, Count) values (:requestid, :requesttype, :created, :count)")
	void insert(@Bind("requestid") int requestid, @Bind("requesttype") String requesttype, @Bind("created") Timestamp created, @Bind("count") int count);
	  
	
}
