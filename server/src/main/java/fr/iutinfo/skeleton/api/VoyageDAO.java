package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface VoyageDAO {

	// ATTENTION format des dates en sqlite ("YYYY-MM-DD HH:MM:SS.SSS")
	@SqlUpdate("create table voyages (id integer primary key autoincrement, iduser integer ,name varchar(1024), ville varchar(100), description text, dateD text, dateF text, capacite integer)")
	void createVoyageTable();

	@SqlUpdate("insert into voyages (iduser,name,ville,description, dateD, dateF, capacite) values (:idUser, :name, :ville, :description, :dateD, :dateF, :capacite)")
	@GetGeneratedKeys
	int insert(@BindBean() Voyage voyage);

	@SqlQuery("select * from voyages where name = :name")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Voyage findByName(@Bind("name") String name);

	@SqlQuery("select * from voyages where search like :name")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Voyage> search(@Bind("name") String name);

	@SqlUpdate("update voyages set name = :voyage.name, ville = :voyage.ville, description = :voyage.description, dateD = :voyage.dateD, dateF = :voyage.dateF, capacite = :voyage.capacite where id = :voyage.id")
	void update(@Bind("id") int id, @BindBean() Voyage voyage);

	@SqlUpdate("drop table if exists voyages")
	void dropVoyageTable();

	@SqlUpdate("delete from voyages where id = :id")
	void delete(@Bind("id") int id);

	@SqlQuery("select * from voyages order by id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Voyage> all();

	@SqlQuery("select * from voyages where id = :id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Voyage findById(@Bind("id") int id);

	void close();
}
