package com.ikea.vaexabox.db;

import java.sql.Timestamp;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.ikea.vaexabox.core.Display;

public interface DisplayDAO {
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

	@SqlUpdate("insert into DisplayMessage (MessageID, DisplayText1, DisplayText2, Created) values (:messageid, :displaytext1, :displaytext2, :created)")
	void insertDisplayMessage(@Bind("messageid") int messageid, @Bind("displaytext1") String displaytext1,
			@Bind("displaytext2") String displaytext2, @Bind("created") Timestamp created);

	// update co-worker registration - update
	@SqlUpdate("update DisplayMessage set DisplayText1 = :displaytext1, DisplayText2 = :displaytext2, Created = :created")
	void updateDisplayMessage(@Bind("displaytext1") String displaytext1, @Bind("displaytext2") String displaytext2,
			@Bind("created") Timestamp created);

	@SqlQuery("select count(*) from DisplayMessage")
	int getCountofMessages();

	@SqlQuery("select DisplayText1, DisplayText2 from DisplayMessage")
	@Mapper(DisplayMapper.class)
	List<Display> getDiplayMessages();

	@SqlUpdate("delete from DisplayMessage")
	void delete();

}
