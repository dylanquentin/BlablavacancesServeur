package fr.iutinfo.skeleton.api;

import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import fr.iutinfo.skeleton.common.dto.UserDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.security.SecureRandom;

public class User implements Principal {
    final static Logger logger = LoggerFactory.getLogger(User.class);
    private static User anonymous = new User(-1, "Anonymous", "anonym");
    private String name;
    private String prenom;
    private String alias;
    private String tel;
    private String anneenaissance;
    private int id = 0;
    private String email;
    private String adresse;
    private String password;
    private String passwdHash;
    private String salt;
    private String search;
    
    // a modifier dans un onglet "parametre de l'utilisateur" ou autre
    private String vehicule, conduire, animal, cuisine, menage, marche, musique, lecture, sexe, organisation, coucher, lever, voyage, religion;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(int id, String name, String alias) {
        this.id = id;
        this.name = name;
        this.alias = alias;
    }
    
    public User(String name, String prenom, String alias, String tel, String daten, int id, String email,
			String adresse) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.alias = alias;
		this.tel = tel;
		this.anneenaissance = daten;
		this.id = id;
		this.email = email;
		this.adresse = adresse;
	}
    
    

	public User(String name, String prenom, String alias, String tel, String anneenaissance, int id, String email,
			String adresse, String password, String passwdHash, String salt, String search, String vehicule,
			String conduire, String animal, String cuisine, String menage, String marche, String musique,
			String lecture, String sexe, String organisation, String coucher, String lever, String voyage,
			String religion) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.alias = alias;
		this.tel = tel;
		this.anneenaissance = anneenaissance;
		this.id = id;
		this.email = email;
		this.adresse = adresse;
		this.password = password;
		this.passwdHash = passwdHash;
		this.salt = salt;
		this.search = search;
		this.vehicule = vehicule;
		this.conduire = conduire;
		this.animal = animal;
		this.cuisine = cuisine;
		this.menage = menage;
		this.marche = marche;
		this.musique = musique;
		this.lecture = lecture;
		this.sexe = sexe;
		this.organisation = organisation;
		this.coucher = coucher;
		this.lever = lever;
		this.voyage = voyage;
		this.religion = religion;
	}
	
	
	public User() {
    }

	
	
    public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDaten() {
		return anneenaissance;
	}

	public void setDaten(String daten) {
		this.anneenaissance = daten;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public static User getAnonymousUser() {
        return anonymous;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        passwdHash = buildHash(password, getSalt());
        this.password = password;
    }

    private String buildHash(String password, String s) {
        Hasher hasher = Hashing.sha256().newHasher();
        hasher.putString(password + s, Charsets.UTF_8);
        return hasher.hash().toString();
    }

    public boolean isGoodPassword(String password) {
        if (isAnonymous()) {
            return false;
        }
        String hash = buildHash(password, getSalt());
        return hash.equals(getPasswdHash());
    }

    public String getPasswdHash() {
        return passwdHash;
    }

    public void setPasswdHash(String passwdHash) {
        this.passwdHash = passwdHash;
    }
    
    @Override
    public String toString() {
        return id + ": " + alias + ", " + name + " <" + email + ">";
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSalt() {
        if (salt == null) {
            salt = generateSalt();
        }
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        Hasher hasher = Hashing.sha256().newHasher();
        hasher.putLong(random.nextLong());
        return hasher.hash().toString();
    }

    public String getAnneenaissance() {
		return anneenaissance;
	}

	public void setAnneenaissance(String anneenaissance) {
		this.anneenaissance = anneenaissance;
	}

	public String getVehicule() {
		return vehicule;
	}

	public void setVehicule(String vehicule) {
		this.vehicule = vehicule;
	}

	public String getConduire() {
		return conduire;
	}

	public void setConduire(String conduire) {
		this.conduire = conduire;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getMenage() {
		return menage;
	}

	public void setMenage(String menage) {
		this.menage = menage;
	}

	public String getMarche() {
		return marche;
	}

	public void setMarche(String marche) {
		this.marche = marche;
	}

	public String getMusique() {
		return musique;
	}

	public void setMusique(String musique) {
		this.musique = musique;
	}

	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getCoucher() {
		return coucher;
	}

	public void setCoucher(String coucher) {
		this.coucher = coucher;
	}

	public String getLever() {
		return lever;
	}

	public void setLever(String lever) {
		this.lever = lever;
	}

	public String getVoyage() {
		return voyage;
	}

	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public void resetPasswordHash() {
        if (password != null && !password.isEmpty()) {
            setPassword(getPassword());
        }
    }

    public boolean isInUserGroup() {
        return !(id == anonymous.getId());
    }

    public boolean isAnonymous() {
        return this.getId() == getAnonymousUser().getId();
    }

    public String getSearch() {
        search = name + " " + alias + " " + email;
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }


    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result + ((animal == null) ? 0 : animal.hashCode());
		result = prime * result + ((anneenaissance == null) ? 0 : anneenaissance.hashCode());
		result = prime * result + ((conduire == null) ? 0 : conduire.hashCode());
		result = prime * result + ((coucher == null) ? 0 : coucher.hashCode());
		result = prime * result + ((cuisine == null) ? 0 : cuisine.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((lecture == null) ? 0 : lecture.hashCode());
		result = prime * result + ((lever == null) ? 0 : lever.hashCode());
		result = prime * result + ((marche == null) ? 0 : marche.hashCode());
		result = prime * result + ((menage == null) ? 0 : menage.hashCode());
		result = prime * result + ((musique == null) ? 0 : musique.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((organisation == null) ? 0 : organisation.hashCode());
		result = prime * result + ((passwdHash == null) ? 0 : passwdHash.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((religion == null) ? 0 : religion.hashCode());
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
		result = prime * result + ((search == null) ? 0 : search.hashCode());
		result = prime * result + ((sexe == null) ? 0 : sexe.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((vehicule == null) ? 0 : vehicule.hashCode());
		result = prime * result + ((voyage == null) ? 0 : voyage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (animal == null) {
			if (other.animal != null)
				return false;
		} else if (!animal.equals(other.animal))
			return false;
		if (anneenaissance == null) {
			if (other.anneenaissance != null)
				return false;
		} else if (!anneenaissance.equals(other.anneenaissance))
			return false;
		if (conduire == null) {
			if (other.conduire != null)
				return false;
		} else if (!conduire.equals(other.conduire))
			return false;
		if (coucher == null) {
			if (other.coucher != null)
				return false;
		} else if (!coucher.equals(other.coucher))
			return false;
		if (cuisine == null) {
			if (other.cuisine != null)
				return false;
		} else if (!cuisine.equals(other.cuisine))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (lecture == null) {
			if (other.lecture != null)
				return false;
		} else if (!lecture.equals(other.lecture))
			return false;
		if (lever == null) {
			if (other.lever != null)
				return false;
		} else if (!lever.equals(other.lever))
			return false;
		if (marche == null) {
			if (other.marche != null)
				return false;
		} else if (!marche.equals(other.marche))
			return false;
		if (menage == null) {
			if (other.menage != null)
				return false;
		} else if (!menage.equals(other.menage))
			return false;
		if (musique == null) {
			if (other.musique != null)
				return false;
		} else if (!musique.equals(other.musique))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (organisation == null) {
			if (other.organisation != null)
				return false;
		} else if (!organisation.equals(other.organisation))
			return false;
		if (passwdHash == null) {
			if (other.passwdHash != null)
				return false;
		} else if (!passwdHash.equals(other.passwdHash))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (religion == null) {
			if (other.religion != null)
				return false;
		} else if (!religion.equals(other.religion))
			return false;
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
		if (search == null) {
			if (other.search != null)
				return false;
		} else if (!search.equals(other.search))
			return false;
		if (sexe == null) {
			if (other.sexe != null)
				return false;
		} else if (!sexe.equals(other.sexe))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (vehicule == null) {
			if (other.vehicule != null)
				return false;
		} else if (!vehicule.equals(other.vehicule))
			return false;
		if (voyage == null) {
			if (other.voyage != null)
				return false;
		} else if (!voyage.equals(other.voyage))
			return false;
		return true;
	}

    public void initFromDto(UserDto dto) {
        this.setAlias(dto.getAlias());
        this.setEmail(dto.getEmail());
        this.setId(dto.getId());
        this.setName(dto.getName());
        this.setPassword(dto.getPassword());
        this.setTel(dto.getTel());
        this.setAdresse(dto.getAdresse());
        this.setPrenom(dto.getPrenom());
        this.setAnneenaissance(dto.getAnneenaissance());
		this.setVehicule(dto.getVehicule());
		this.setConduire(dto.getConduire());
		this.setAnimal(dto.getAnimal());
		this.setCuisine(dto.getCuisine());
		this.setMenage(dto.getMenage());
		this.setMarche(dto.getMarche());
		this.setMusique(dto.getMusique());
		this.setLecture(dto.getLecture());
		this.setSexe(dto.getSexe());
		this.setOrganisation(dto.getOrganisation());
		this.setCoucher(dto.getCoucher());
		this.setLever(dto.getLever());
		this.setVoyage(dto.getVoyage());
		this.setReligion(dto.getReligion());
    }

	public UserDto convertToDto() {
        UserDto dto = new UserDto();
        dto.setAlias(this.getAlias());
        dto.setEmail(this.getEmail());
        dto.setId(this.getId());
        dto.setName(this.getName());
        dto.setPassword(this.getPassword());
        dto.setTel(this.getTel());
        dto.setAdresse(this.getAdresse());
        dto.setPrenom(this.getPrenom());
        dto.setAnneenaissance(this.getAnneenaissance());
		dto.setVehicule(this.getVehicule());
		dto.setConduire(this.getConduire());
		dto.setAnimal(this.getAnimal());
		dto.setCuisine(this.getCuisine());
		dto.setMenage(this.getMenage());
		dto.setMarche(this.getMarche());
		dto.setMusique(this.getMusique());
		dto.setLecture(this.getLecture());
		dto.setSexe(this.getSexe());
		dto.setOrganisation(this.getOrganisation());
		dto.setCoucher(this.getCoucher());
		dto.setLever(this.getLever());
		dto.setVoyage(this.getVoyage());
		dto.setReligion(this.getReligion());
        return dto;
    }
}
