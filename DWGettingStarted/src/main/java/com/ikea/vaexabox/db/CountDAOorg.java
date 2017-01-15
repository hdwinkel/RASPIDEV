package com.ikea.vaexabox.db;

import org.skife.jdbi.v2.sqlobject.SqlQuery;

public interface CountDAOorg {
	  /*
	  @SqlUpdate("create table something (id int primary key, name varchar(100))")
	  void createSomethingTable();
      
	  @SqlUpdate("insert into something (id, name) values (:id, :name)")
	  void insert(@Bind("id") int id, @Bind("name") String name);

	  @SqlQuery("select name from something where id = :id")
	  String findNameById(@Bind("id") int id);
	  */
	  
	@SqlQuery("select sum(count) from HelpRequest")
	int getCount();
	  
	
}
