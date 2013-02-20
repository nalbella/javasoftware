package com.microforum.gestorencuestas.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ENCUESTA")
public class Encuesta {

	@Id
	@GenericGenerator(name="uuid-gen",strategy="uuid")
	@GeneratedValue(generator="uuid-gen")
	private String ref;
	@Column(name="PROPOSITO_ENCUESTA")
	private String proposito;
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="ENCUESTA_PREGUNTA",
	joinColumns=@JoinColumn(name="REF_ENCUESTA"),
	inverseJoinColumns=@JoinColumn(name="REF_PREGUNTA"))
	private Collection<Pregunta> preguntas=new ArrayList<Pregunta>();
	
	@ManyToOne
	@JoinColumns(value={@JoinColumn(name="NUMERO_ID"),
			@JoinColumn(name="TIPO_DOCUMENTO")})
	private Administrador autor;
	
	public Administrador getAutor() {
		return autor;
	}
	public void setAutor(Administrador autor) {
		this.autor = autor;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getProposito() {
		return proposito;
	}
	public void setProposito(String proposito) {
		this.proposito = proposito;
	}
	public Collection<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(Collection<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	
}
