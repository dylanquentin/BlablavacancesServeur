package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;

public class UserDto {
    final static Logger logger = LoggerFactory.getLogger(UserDto.class);
    private String name;
    private String alias;
    private int id = 0;
    private String email;
    private String password;
	private String adresse;
    private String tel;
	private String prenom;
	private String anneenaissance;
	private String vehicule, conduire, animal, cuisine, menage, marche, musique, lecture, sexe, organisation, coucher, lever, voyage, religion;
	
	
	
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

	
	
    public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
    
    public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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
        this.password = password;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
