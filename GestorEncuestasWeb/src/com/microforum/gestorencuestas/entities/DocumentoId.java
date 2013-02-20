package com.microforum.gestorencuestas.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DocumentoId implements Serializable{
	
	public static final int DNI=1;
	public static final int PASAPORTE=2;
	public static final int NIE=3;
	
	@Column(name="NUMERO_ID")
	private String numeroId;
	@Column(name="TIPO_DOCUMENTO")
	private int tipoDocumento;
	
	public String getNumeroId() {
		return numeroId;
	}
	public void setNumeroId(String numeroId) {
		this.numeroId = numeroId;
	}
	public int getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof DocumentoId))
			return false;
		DocumentoId otro=(DocumentoId)obj;
		if(otro.getTipoDocumento()!=tipoDocumento)
			return false;
		if(!otro.getNumeroId().equals(numeroId))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		return numeroId.hashCode()+tipoDocumento;
	}
	
	
}
