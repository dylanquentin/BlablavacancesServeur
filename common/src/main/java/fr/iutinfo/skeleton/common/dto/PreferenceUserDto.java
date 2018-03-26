package fr.iutinfo.skeleton.common.dto;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PreferenceUserDto {
    final static Logger logger = LoggerFactory.getLogger(PreferenceDto.class);
    private int idUser = 1;
    private String motive;
    private String neutre;
    private String pasEnvie;
    
	public int getIdUser() {
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
	

    
}
