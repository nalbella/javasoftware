package com.microforum.gestorencuestas.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue(value="1")
public class Administrador extends Usuario{
	@Column(name="NSS")
	private String nSS;

	@ManyToMany
	@JoinTable(name="ADMINISTRADOR_TRABAJO",
	joinColumns={@JoinColumn(name="NUMERO_DOCUMENTO"),
			@JoinColumn(name="TIPO_DOCUMENTO")},
	inverseJoinColumns=@JoinColumn(name="TRABAJO_ID"))
	private Collection<Trabajo> trabajos=new ArrayList<Trabajo>();
	
	
	public Collection<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(Collection<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public String getnSS() {
		return nSS;
	}

	public void setnSS(String nSS) {
		this.nSS = nSS;
	}
	
	
	
}
