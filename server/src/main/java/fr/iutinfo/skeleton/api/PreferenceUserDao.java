package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface PreferenceUserDao {
	

		// ATTENTION format des dates en sqlite ("YYYY-MM-DD HH:MM:SS.SSS")
		@SqlUpdate("create table preferenceUser (idUser integer primary key , motive text, neutre text, pasEnvie text)")
		void createpreferenceUserTable();

		@SqlUpdate("insert into preferenceUser (idUser , motive , neutre , pasEnvie) values (:idUser , :motive , :neutre , :pasEnvie)")
		@GetGeneratedKeys
		int insert(@BindBean() PreferenceUser preferenceUser);

		@SqlQuery("select * from preferenceUser where idUser = :idUser")
		@RegisterMapperFactory(BeanMapperFactory.class)
		PreferenceUser findById(@Bind("idUser") int idUser);
		

		@SqlQuery("select * from preferenceUser order by idUser")
		@RegisterMapperFactory(BeanMapperFactory.class)
		List<PreferenceUser> all();

		@SqlQuery("select * from voyages where idUser = :idUser")
		@RegisterMapperFactory(BeanMapperFactory.class)
		List<PreferenceUser> search(@Bind("idUser") String idUser);


		@SqlUpdate("update preferenceUser set motive = :motive, neutre = :neutre, pasEnvie = :pasEnvie")
		void update(@Bind("idUser") int idUser, @BindBean() PreferenceUser preferenceUser);

		@SqlUpdate("drop table if exists preferenceUser")
		void dropPreferenceUserTable();

		@SqlUpdate("delete from preferenceUser where idUser = :idUser")
		void delete(@Bind("idUser") int idUser);



	

}
