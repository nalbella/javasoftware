package com.microforum.gestorencuestas.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class EstiloSesion {
	private String style="normalSize";

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	
	public void setLargeSize(ActionEvent e){
		System.out.println("Large Size");
		style="largeSize";
		
	}
	public String setNormalSize(){
		System.out.println("Normal Size");
		style="normalSize";
		return "normalSizeTest";
	}
}
