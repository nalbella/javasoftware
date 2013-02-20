package com.microforum.gestorencuestas.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="EVENTO_ENCUESTA")
public class EventoEncuesta {
	@Id
	@Column(name="REF_EVENTO_ENCUESTA")
	@GenericGenerator(name="uuid-gen",strategy="uuid")
	@GeneratedValue(generator="uuid-gen")
	private String ref;
	@ManyToOne
	@JoinColumns(value={@JoinColumn(name="NUMERO_ID"),
			@JoinColumn(name="TIPO_DOCUMENTO")})
	private UsuarioRegistrado encuestado;
	@ManyToOne
	@JoinColumn(name="REF_ENCUESTA")
	private Encuesta encuesta;
	@Column(name="FECHA_ENCUESTA")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ElementCollection
	@JoinTable(name="REGISTRO_RESPUESTA_ENCUESTA",
	joinColumns=@JoinColumn(name="REF_EVENTO_ENCUESTA"))
	private Collection<RegistroRespuestaEncuesta> respuestas=
			new ArrayList<RegistroRespuestaEncuesta>();
	
	
	public Collection<RegistroRespuestaEncuesta> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(Collection<RegistroRespuestaEncuesta> respuestas) {
		this.respuestas = respuestas;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public UsuarioRegistrado getEncuestado() {
		return encuestado;
	}
	public void setEncuestado(UsuarioRegistrado encuestado) {
		this.encuestado = encuestado;
	}
	public Encuesta getEncuesta() {
		return encuesta;
	}
	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
