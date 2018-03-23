package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface UserDao {
    @SqlUpdate("create table users (id integer primary key autoincrement, name varchar(100), alias varchar(100), email varchar(100), passwdHash varchar(64), salt varchar(64), search varchar(1024), tel varchar(32), adresse varchar(1024), prenom varchar(100),"
    		+ " vehicule varchar(200), conduire varchar(200), anneenaissance varchar(32), animal varchar(200), cuisine varchar(200), menage varchar(100), marche varchar(100), musique varchar(200), lecture varchar(200), sexe varchar(32), organisation varchar(200),"
    		+ " coucher varchar(32), lever varchar(32), voyage varchar(200), religion varchar(200))")
    void createUserTable();

    @SqlUpdate("insert into users (name, alias, email, passwdHash, salt, search, tel, adresse, prenom, vehicule, conduire, anneenaissance, animal, cuisine, menage, marche, musique, lecture, sexe, organisation, coucher, lever, voyage, religion) "
    		+ "values (:name, :alias, :email, :passwdHash, :salt, :search, :tel, :adresse, :prenom, :vehicule, :conduire, :anneenaissance, :animal, :cuisine, :menage, :marche, :musique, :lecture, :sexe, :organisation, :coucher, :lever, :voyage, :religion)")
    @GetGeneratedKeys
    int insert(@BindBean() User user);

    @SqlQuery("select * from users where name = :name")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User findByName(@Bind("name") String name);

    @SqlQuery("select * from users where search like :name")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<User> search(@Bind("name") String name);
    
    @SqlUpdate("update users set name = :user.name, alias = :user.alias, email = :user.email, passwdHash = :user.passwdHash, salt = :user.salt, search = :user.search, tel = :user.tel, adresse = :user.adresse, prenom = :user.prenom, "
    		+ " vehicule = :user.vehicule, conduire = :user.conduire, anneenaissance = :user.anneenaissance, animal = :user.animal, cuisine = :user.cuisine, menage = :user.menage, marche = :user.marche, musique = :user.musique, lecture = :user.lecture, sexe = :user.sexe, "
    		+ " organisation = :user.organisation , coucher = :user.coucher, lever = :user.lever, voyage = :user.lever, religion = :user.religion where id = :user.id")
    void update(@Bind("id") int id, @BindBean() User user);

    @SqlUpdate("drop table if exists users") 
    void dropUserTable();

    @SqlUpdate("delete from users where id = :id")
    void delete(@Bind("id") int id);

    @SqlQuery("select * from users order by id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<User> all();

    @SqlQuery("select * from users where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User findById(@Bind("id") int id);

    void close();

}
