package fr.iutinfo.skeleton.common.dto;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VoyageDto {
    final static Logger logger = LoggerFactory.getLogger(VoyageDto.class);
    private String name;
    private String ville;
    private int id = 0;
    private int idUser = 0;
    private String description;
    private int capacite;
    private Calendar depart ;
    private Calendar retour;
    
    
	public Calendar getDepart() {
		return depart;
	}

	public void setDepart(Calendar depart) {
		this.depart = depart;
	}

	public Calendar getRetour() {
		return retour;
	}

	public void setRetour(Calendar retour) {
		this.retour = retour;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getCapacite() {
		return capacite;
	}
	
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
 
}
