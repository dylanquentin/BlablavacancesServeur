package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.iutinfo.skeleton.common.dto.MessagerieDto;

public class Messagerie {
	final static Logger logger = LoggerFactory.getLogger(Messagerie.class);

	private int idMessage;
	private String text;
	
	public Messagerie() {
		super();
	}
	
	public Messagerie(int id) {
		super();
		this.idMessage = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMessage;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Messagerie other = (Messagerie) obj;
		if (idMessage != other.idMessage)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	public int getIdMessagerie() {
		return idMessage;
	}

	public void setIdMessagerie(int idMessage) {
		this.idMessage = idMessage;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void initFromDto(MessagerieDto dto) {
		this.setText(dto.getText());
		this.setIdMessagerie(dto.getId());
	}
	
	public MessagerieDto convertToDto() {
        MessagerieDto dto = new MessagerieDto();
        dto.setText(this.getText());
        dto.setId(this.getIdMessagerie());
        return dto;
    }
}

