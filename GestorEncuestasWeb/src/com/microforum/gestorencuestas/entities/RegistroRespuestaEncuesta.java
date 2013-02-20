package com.microforum.gestorencuestas.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
public class RegistroRespuestaEncuesta {
	@Column(name="RESPUESTA")
	private String respuesta;
	@ManyToOne
	@JoinColumn(name="REF_PREGUNTA")
	private Pregunta pregunta;
	
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
}
