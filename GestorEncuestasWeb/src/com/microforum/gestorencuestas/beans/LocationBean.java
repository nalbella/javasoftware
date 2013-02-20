package com.microforum.gestorencuestas.beans;

import java.io.*;
import java.util.*;
import javax.faces.model.*;
import javax.faces.bean.*;

/** From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, 
 *  Spring, Hibernate/JPA, and Java programming</a>.
 */

@ManagedBean 
@SessionScoped
public class LocationBean implements Serializable {
  private String state, city;
  private boolean isCityListDisabled = true;

  public String getState() {
    return (state);
  }

  public void setState(String state) {
    this.state = state;
    isCityListDisabled = false;
  }

  public String getCity() {
    return(city);
  }

  public void setCity(String city) {
    this.city = city;
  }
  
  public boolean isCityListDisabled() {
    return(isCityListDisabled);
  }
  
  public List<SelectItem> getStates() {
    List<SelectItem> states = new ArrayList<SelectItem>();
    states.add(new SelectItem("--- Select State ---"));
    for(StateInfo stateData: StateInfo.getNearbyStates()) {
      states.add(new SelectItem(stateData.getStateName()));
    }
    return(states);
  }
  
  public SelectItem[] getCities() {
    SelectItem[] cities = 
      { new SelectItem("--- Choose City ---")};
    if(!isCityListDisabled && (state != null)) {
      for(StateInfo stateData: StateInfo.getNearbyStates()) {
        if(state.equals(stateData.getStateName())) {
          cities = stateData.getCities();
          break;
        }
      }
    }
    return(cities);
  }
}
