package fr.iutinfo.skeleton.api;

import java.sql.Date;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.VoyageDto;

public class Voyage{
    final static Logger logger = LoggerFactory.getLogger(Voyage.class);

	private int id;
	private int idUser;
	private String name;
	private String ville;
	private String description;
	private String depart;
	private String retour;
	private int capacite;


	public Voyage() {
	}

	public Voyage(int id2, int idUser2, String name, String ville2) {
		this.id = id2;
		this.name = name;
		idUser = idUser2;
		ville = ville2;
	}

	public Voyage(int id, int idUser, String name, String ville, String description, String depart, String retour,
			int capacite) {
		this(id, idUser, name, ville);
		this.description = description;
		this.depart = depart;
		this.retour = retour;
		this.capacite = capacite;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getRetour() {
		return retour;
	}

	public void setRetour(String retour) {
		this.retour = retour;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idUser;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((retour == null) ? 0 : retour.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		result = prime * result + capacite;
		result = prime * result + ((depart == null) ? 0 : depart.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Voyage other = (Voyage) obj;
		if (capacite != other.capacite)
			return false;
		if (depart == null) {
			if (other.depart != null)
				return false;
		} else if (!depart.equals(other.depart))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (idUser != other.idUser)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (retour == null) {
			if (other.retour != null)
				return false;
		} else if (!retour.equals(other.retour))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	
public void initFromDto(VoyageDto dto) {
		this.setName(dto.getName());
		this.setVille(dto.getVille());
		this.setId(dto.getId());
		this.setIdUser(dto.getIdUser());
		this.setDescription(dto.getDescription());
		this.setCapacite(dto.getCapacite());
		this.setDepart(dto.getDepart());
		this.setRetour(dto.getRetour());
	}
	
	public VoyageDto convertToDto() {
        VoyageDto dto = new VoyageDto();
        dto.setName(this.getName());
        dto.setVille(this.getVille());
        dto.setId(this.getId());
        dto.setIdUser(this.getIdUser());
        dto.setDescription(this.getDescription());
        dto.setCapacite(this.getCapacite());
        dto.setDepart(this.getDepart());
        dto.setRetour(this.getRetour());
        
        return dto;
    }

}
