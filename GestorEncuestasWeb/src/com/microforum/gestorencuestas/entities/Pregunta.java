package com.microforum.gestorencuestas.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PREGUNTA_ENCUESTA")
@Embeddable
public class Pregunta {
	
	public static final int SI_NO=1;
	public static final int SI_NO_NSNC=2;
	public static final int EXPRESIVA=3;
	
	@Id
	@Column(name="REF_PREGUNTA")
	@GenericGenerator(name="uuid-gen",strategy="uuid")
	@GeneratedValue(generator="uuid-gen")
	private String ref;
	@Column(name="TIPO_PREGUNTA")
	private int tipo;
	@Column(name="TEXTO_PREGUNTA")
	private String texto;
	@ManyToMany(mappedBy="preguntas")
	private Collection<Encuesta> encuestas=new ArrayList<Encuesta>();
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
	public Collection<Encuesta> getEncuestas() {
		return encuestas;
	}
	public void setEncuestas(Collection<Encuesta> encuestas) {
		this.encuestas = encuestas;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String codPregunta) {
		this.ref = codPregunta;
	} 
	
}
