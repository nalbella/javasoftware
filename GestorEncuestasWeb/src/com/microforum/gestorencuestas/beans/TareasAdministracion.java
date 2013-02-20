package com.microforum.gestorencuestas.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TareasAdministracion {
	private static String tarea;
	public String[] adminTasks={
		"alta pregunta","alta encuesta"
	};
	public String getTarea() {
		return tarea;
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	public String[] getAdminTasks() {
		return adminTasks;
	}
	
	
}
