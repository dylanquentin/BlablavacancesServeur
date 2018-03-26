package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface MessagerieDao {
	

		@SqlUpdate("create table messages (idMessage integer primary key , text text)")
		void createMessagesTable();

		@SqlUpdate("insert into messages (text) values (:text)")
		@GetGeneratedKeys
		int insert(@BindBean() Messagerie message);

		@SqlQuery("select * from messages where idMessage = :idMessage")
		@RegisterMapperFactory(BeanMapperFactory.class)
		Messagerie findById(@Bind("idMessage") int idMessage);
		
		@SqlQuery("select * from messages order by idMessage")
		@RegisterMapperFactory(BeanMapperFactory.class)
		List<Messagerie> all();
		
		@SqlQuery("select * from messages where search like :id")
	    @RegisterMapperFactory(BeanMapperFactory.class)
	    List<Messagerie> search(@Bind("idMessage") String idMessage);

		@SqlUpdate("update messages set text = :text")
		void update(@Bind("idMessage") int idMessage, @BindBean() Messagerie messagerie);

		@SqlUpdate("drop table if exists messages")
		void dropMessagesTable();

		@SqlUpdate("delete from preference where idMessage = :idMessage")
		void delete(@Bind("idMessage") int idMessage);


}

