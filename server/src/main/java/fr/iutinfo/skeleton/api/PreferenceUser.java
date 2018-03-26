package fr.iutinfo.skeleton.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.PreferenceUserDto;

public class PreferenceUser{
    final static Logger logger = LoggerFactory.getLogger(Preference.class);

	private int idUser;
	private String motive;
	private String neutre;
	private String pasEnvie;
	


	public PreferenceUser() {
	}


	public PreferenceUser(int idUser) {
		this.idUser = idUser; 
	}


	
	public PreferenceUser(int idUser, String motive, String neutre, String pasEnvie) {
		super();
		this.idUser = idUser;
		this.motive = motive;
		this.neutre = neutre;
		this.pasEnvie = pasEnvie;
	}


	
	public int getidUser() {
		return idUser;
	}


	public void setidUser(int idUser) {
		this.idUser = idUser;
	}


	public String getMotive() {
		return motive;
	}


	public void setMotive(String motive) {
		this.motive = motive;
	}


	public String getNeutre() {
		return neutre;
	}


	public void setNeutre(String neutre) {
		this.neutre = neutre;
	}


	public String getPasEnvie() {
		return pasEnvie;
	}


	public void setPasEnvie(String pasEnvie) {
		this.pasEnvie = pasEnvie;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUser;
		result = prime * result + ((motive == null) ? 0 : motive.hashCode());
		result = prime * result + ((neutre == null) ? 0 : neutre.hashCode());
		result = prime * result + ((pasEnvie == null) ? 0 : pasEnvie.hashCode());
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
		PreferenceUser other = (PreferenceUser) obj;
		if (idUser != other.idUser)
			return false;
		if (motive == null) {
			if (other.motive != null)
				return false;
		} else if (!motive.equals(other.motive))
			return false;
		if (neutre == null) {
			if (other.neutre != null)
				return false;
		} else if (!neutre.equals(other.neutre))
			return false;
		if (pasEnvie == null) {
			if (other.pasEnvie != null)
				return false;
		} else if (!pasEnvie.equals(other.pasEnvie))
			return false;
		return true;
	}

	
public void initFromDto(PreferenceUserDto dto) {
		this.setidUser(dto.getIdUser());
		this.setMotive(dto.getMotive());;
		this.setNeutre(dto.getNeutre());
		this.setPasEnvie(dto.getPasEnvie());
	}
	
	public PreferenceUserDto convertToDto() {
        PreferenceUserDto dto = new PreferenceUserDto();
        dto.setidUser(this.getidUser());
        dto.setMotive(this.getMotive());
        dto.setNeutre(this.getNeutre());
        dto.setPasEnvie(this.getPasEnvie());
        return dto;
    }

}
