package fr.iutinfo.skeleton.api;

import java.util.Calendar;
import java.util.List;

import javax.ws.rs.core.GenericType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.PreferenceDto;
import fr.iutinfo.skeleton.common.dto.UserDto;
import fr.iutinfo.skeleton.common.dto.VoyageDto;

public class Helper {
	private final static Logger logger = LoggerFactory.getLogger(Helper.class);
	private static final UserDao daoU = BDDFactory.getDbi().open(UserDao.class);
	private static final VoyageDao daoV = BDDFactory.getDbi().open(VoyageDao.class);



	static GenericType<List<UserDto>> listUserResponseType = new GenericType<List<UserDto>>() {
	};
	static GenericType<List<VoyageDto>> listVoyageResponseType = new GenericType<List<VoyageDto>>() {
	};

	
	public static void initDb() {
		daoU.dropUserTable();
		daoU.createUserTable();
		daoV.dropVoyageTable();
		daoV.createVoyageTable();
	}

/*
	private static Preference createPreference(Preference preference) {
		int id = daoP.insert(preference);
		preference.setIdVoyage(id);
		return preference;
	}

	private static Preference createFullPreference(int idVoyage, String motive, String neutre, String pasEnvie) {
		Preference preference = new Preference(idVoyage, motive, neutre, pasEnvie);
		return preference;
	}

	*/
	static Voyage createVoyageWithName(String name, String ville) {
		Voyage voyage = new Voyage(0, 0, name, ville);
		return createVoyage(voyage);
	}

	private static Voyage createVoyage(Voyage voyage) {
		int id = daoV.insert(voyage);
		voyage.setId(id);
		return voyage;
	}

	private static Voyage createFullVoyage(int id, int idUser, String name, String ville, String description,
			Calendar depart, Calendar retour, int capacite) {
		Voyage voyage = new Voyage(id, idUser, name, ville);
		voyage.setDescription(description);
		voyage.setDepart(depart);
		voyage.setRetour(retour);
		int idV = daoV.insert(voyage);
		voyage.setId(idV);
		return voyage;
	}

	static void createvl() {
		createFullVoyage(0, 10, "test", "Lille", "blabla", Calendar.getInstance(), Calendar.getInstance(), 3);
	}

	static Voyage createvp() {
		return createFullVoyage(1, 10, "test", "Paris", "blabla", Calendar.getInstance(), Calendar.getInstance(), 3);
	}

	static Voyage createvn() {
		return createFullVoyage(2, 10, "test", "Nice", "blabla", Calendar.getInstance(), Calendar.getInstance(), 3);
	}

	static Voyage createvb() {
		return createFullVoyage(3, 10, "test", "Biarritz", "blabla", Calendar.getInstance(), Calendar.getInstance(), 3);
	}

	static User createUserWithName(String name) {
		User user = new User(0, name);
		return createUser(user);
	}

	static User createUserWithAlias(String name, String alias) {
		User user = new User(0, name, alias);
		return createUser(user);
	}

	static User createUserWithEmail(String name, String email) {
		User user = new User(0, name);
		user.setEmail(email);
		return createUser(user);
	}

	public static User createUserWithPassword(String name, String passwd, String salt) {
		User user = new User(0, name);
		user.setSalt(salt);
		user.setPassword(passwd);
		logger.debug("createUserWithPassword Hash : " + user.getPasswdHash());
		return createUser(user);
	}

	private static User createUser(User user) {
		int id = daoU.insert(user);
		user.setId(id);
		return user;
	}

	private static User createFullUSer(String name, String alias, String email, String paswword) {
		User user = new User(0, name);
		user.setAlias(alias);
		user.setEmail(email);
		user.setPassword(paswword);
		int id = daoU.insert(user);
		user.setId(id);
		return user;
	}

	static void createRms() {
		createFullUSer("Richard Stallman", "RMS", "rms@fsf.org", "gnuPaswword");
	}

	static User createRob() {
		return createFullUSer("Robert Capillo", "rob", "rob@fsf.org", "paswword");
	}

	static User createLinus() {
		return createFullUSer("Linus Torvalds", "linus", "linus@linux.org", "paswword");
	}

	static User createIan() {
		return createFullUSer("Ian Murdock", "debian", "ian@debian.org", "mot de passe");
	}
}
