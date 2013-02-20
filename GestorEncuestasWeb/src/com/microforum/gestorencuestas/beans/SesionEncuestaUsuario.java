package com.microforum.gestorencuestas.beans;
 import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.microforum.gestorencuestas.entities.Encuesta;
import com.microforum.gestorencuestas.entities.Pregunta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
@ManagedBean
@SessionScoped
public class SesionEncuestaUsuario {
	private String proposito="general";
	private List<SelectItem> coleccionEncuestas;
	private List<SelectItem> coleccionPreguntasPorEncuesta;
	private String encuesta;
	private String textoEnriquecidoPrueba;
	private String textoPrueba;
	private String textoEnriquecido2Prueba;
	
	
	public String getTextoEnriquecido2Prueba() {
		return textoEnriquecido2Prueba;
	}

	public void setTextoEnriquecido2Prueba(String textoEnriquecido2Prueba) {
		System.out.println("Modificando textoEnriquecido2Prueba...");
		this.textoEnriquecido2Prueba = textoEnriquecido2Prueba;
	}

	public String getTextoEnriquecidoPrueba() {
		return textoEnriquecidoPrueba;
	}

	public void setTextoEnriquecidoPrueba(String textoEnriquecidoPrueba) {
		System.out.println("Modificando textoEnriquecidoPrueba...");
		this.textoEnriquecidoPrueba = textoEnriquecidoPrueba;
	}

	public String getTextoPrueba() {
		return textoPrueba;
	}

	public void setTextoPrueba(String textoPrueba) {
		System.out.println("Modificando textoPrueba...");
		this.textoPrueba = textoPrueba;
		textoEnriquecidoPrueba="Enriqueciendo " + textoPrueba;
	}

	public void setPreguntas(ValueChangeEvent e){
		String ref=(String) e.getNewValue();
		Configuration conf=new Configuration();
		SessionFactory sf=conf.configure().buildSessionFactory();
		Session session=sf.openSession();
		Encuesta encuesta=(Encuesta) session.get(Encuesta.class,ref);
		Collection<Pregunta> preguntas=encuesta.getPreguntas();
		for(Pregunta pregunta:preguntas){
			SelectItem item=new SelectItem(pregunta.getRef(),
					pregunta.getTexto());
			coleccionPreguntasPorEncuesta.add(item);
		}
	}
	
	
	
	public String getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(String encuesta) {
		this.encuesta = encuesta;
		System.out.println("Seleccionando encuesta...");
	}

	public SesionEncuestaUsuario(){
		coleccionEncuestas=new ArrayList<SelectItem>();
		coleccionEncuestas.add(new SelectItem("----Encuestas-----"));
		coleccionPreguntasPorEncuesta=new ArrayList<SelectItem>();
		coleccionPreguntasPorEncuesta.add(new SelectItem("----Preguntas-----"));
		Configuration conf=new Configuration();
		SessionFactory sf=conf.configure().buildSessionFactory();
		Session session=sf.openSession();
		Query query=session.createQuery("from Encuesta");
		List<Encuesta> encuestas=query.list();
		for(Encuesta e:encuestas){
			String ref=e.getRef();
			String proposito=e.getProposito();
			SelectItem item=new SelectItem(ref,ref + ":" + proposito);
			coleccionEncuestas.add(item);
		}
	}
	
	public void seleccionarEncuesta(ValueChangeEvent e){
		System.out.println("Seleccionando encuesta...");
	}
	
	public void seleccionarEncuestaA(ActionEvent e){
		System.out.println("Seleccionando encuesta...");
	}
	public List<SelectItem> getColeccionEncuestas() {
		return coleccionEncuestas;
	}
	public void setColecionEncuestas(List<SelectItem> coleccionEncuestas) {
		this.coleccionEncuestas = coleccionEncuestas;
	}
	public List<SelectItem> getColeccionPreguntasPorEncuesta() {
		return coleccionPreguntasPorEncuesta;
	}
	public void setColeccionPreguntasPorEncuesta(
			List<SelectItem> coleccionPreguntasPorEncuesta) {
		this.coleccionPreguntasPorEncuesta = coleccionPreguntasPorEncuesta;
	}
}
