package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessagerieDto {
	final static Logger logger = LoggerFactory.getLogger(MessagerieDto.class);
	private String text;
	private int idMessage;
	public int getId() {
		return idMessage;
	}
	public void setId(int id) {
		this.idMessage = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}

