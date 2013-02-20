package com.microforum.gestorencuestas.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.microforum.gestorencuestas.entities.Pregunta;

@ManagedBean(eager=true)
@ApplicationScoped
public class BancoPreguntas {
	private Map<String,String> mapaPreguntas;
	private List<String> arrayPreguntas;
	private String nuevaPregunta;
	private int tipo; 
	private List<SelectItem> preguntaItems;
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getNuevaPregunta() {
		return nuevaPregunta;
	}
	public void setNuevaPregunta(String nuevaPregunta) {
		this.nuevaPregunta = nuevaPregunta;
	}
	public BancoPreguntas(){
		Configuration conf=new Configuration();
		SessionFactory sf=conf.configure().buildSessionFactory();
		Session session=sf.openSession();
		Query query=session.createQuery("from Pregunta");
		List<Pregunta> listadoPreguntas=query.list();
		int tam=listadoPreguntas.size();
		preguntaItems=new ArrayList<SelectItem>();
		arrayPreguntas=new ArrayList();
		preguntaItems.add(new SelectItem("----Preguntas----"));
		for(int i=0;i<listadoPreguntas.size();i++){
			arrayPreguntas.add(listadoPreguntas.get(i).getTexto());
			String ref=listadoPreguntas.get(i).getRef();
			String texto=listadoPreguntas.get(i).getTexto();
			preguntaItems.add(new SelectItem(ref,texto));
		}
		session.close();
	}
	public List<String> getArrayPreguntas() {
		return arrayPreguntas;
	}
	public void setArrayPreguntas(List<String> arrayPreguntas) {
		this.arrayPreguntas = arrayPreguntas;
	}
	
	public List<SelectItem> getArrayItemPregunta() {
		return preguntaItems;
	}
	
	public void addPregunta(ActionEvent e){
		Configuration conf=new Configuration();
		SessionFactory sf=conf.configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Pregunta p=new Pregunta();
		p.setTexto(nuevaPregunta);
		p.setTipo(tipo);
		//p.setAutor();
		session.save(p);
		tr.commit();
		session.close();
		SelectItem item=new SelectItem(p.getRef(),p.getTexto());
		preguntaItems.add(item);
		
	}
}
