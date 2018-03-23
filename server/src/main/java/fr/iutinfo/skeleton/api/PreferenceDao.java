package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface PreferenceDao {
	

		// ATTENTION format des dates en sqlite ("YYYY-MM-DD HH:MM:SS.SSS")
		@SqlUpdate("create table preference (idVoyage integer primary key , motive text, neutre text, pasEnvie text")
		void createPreferenceTable();

		@SqlUpdate("insert into preference (idVoyage , motive , neutre , pasEnvie) values (:idVoyage , :motive , :neutre , :pasEnvie)")
		@GetGeneratedKeys
		int insert(@BindBean() Preference preference);

		@SqlQuery("select * from preference where idVoyage = :idVoyage")
		@RegisterMapperFactory(BeanMapperFactory.class)
		Preference findById(@Bind("idVoyage") int idVoyage);
		

		@SqlQuery("select * from preference order by idVoyage")
		@RegisterMapperFactory(BeanMapperFactory.class)
		List<Preference> all();

		@SqlQuery("select * from voyages where idVoyage = :idVoyage")
		@RegisterMapperFactory(BeanMapperFactory.class)
		List<Preference> search(@Bind("idVoyage") String idVoyage);


		@SqlUpdate("update preference set motive = :preference.motive, neutre = :preference.neutre, pasEnvie = :preference.pasEnvie")
		void update(@Bind("idVoyage") int idVoyage, @BindBean() Preference preference);

		@SqlUpdate("drop table if exists preference")
		void dropVoyageTable();

		@SqlUpdate("delete from preference where idVoyage = :idVoyage")
		void delete(@Bind("idVoyage") int idVoyage);



	

}
