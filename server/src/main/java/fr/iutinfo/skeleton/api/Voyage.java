package fr.iutinfo.skeleton.api;

import java.util.Calendar;

public class Voyage {

	private int id;
	private int idUser;
	private String ville;
	private String description;
	private Calendar depart ;
	private Calendar retour ; 
	private int capacite;
	public Voyage(int id, int idUser, String ville, String description, Calendar depart, Calendar retour,
			int capacite) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.ville = ville;
		this.description = description;
		this.depart = depart;
		this.retour = retour;
		this.capacite = capacite;
	}
	
	
	
	
}
