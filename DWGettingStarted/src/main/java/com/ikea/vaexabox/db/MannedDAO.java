package com.ikea.vaexabox.db;

import java.sql.Timestamp;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.ikea.vaexabox.core.Display;

public interface MannedDAO {
	/*
	 * @SqlUpdate("create table something (id int primary key, name varchar(100))"
	 * ) void createSomethingTable();
	 * 
	 * @SqlUpdate("insert into something (id, name) values (:id, :name)") void
	 * insert(@Bind("id") int id, @Bind("name") String name);
	 * 
	 * @SqlQuery("select name from something where id = :id") String
	 * findNameById(@Bind("id") int id);
	 */

	// insert manned (if manned=1 else manned=0)
	@SqlUpdate("insert into Manned (ID, IsManned, Updated) values (:id, :ismanned, :updated)")
	void insertIsManned(@Bind("id") int id, @Bind("ismanned") int ismanned,
			@Bind("updated") Timestamp updated);

	// update manned (if manned=1 else manned=0)
	@SqlUpdate("update Manned set IsManned = :ismanned, Updated = :updated")
	void updateIsManned(
			@Bind("ismanned") int ismanned, 
			@Bind("updated") Timestamp updated			
			);
	
	// query if manned (manned==1)
		@SqlQuery("select IsManned from Manned where id = :id")
		int getIsManned(
				@Bind("id") int id 
				);

		@SqlUpdate("delete from Manned")
		void delete();
		
}
