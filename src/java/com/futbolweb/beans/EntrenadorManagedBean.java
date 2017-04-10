/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.beans;

import com.futbolweb.backend.entities.Entrenador;
import com.futbolweb.backend.facade.EntrenadorFacade;
import com.futbolweb.converters.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "entrenadorManagedBean")
@RequestScoped
public class EntrenadorManagedBean implements Serializable, InterfaceController<Entrenador>{

    private Entrenador entrenador;
     @EJB
  private EntrenadorFacade entrenadorEJB;
    public EntrenadorManagedBean() {
    }
    
    
    @PostConstruct
    public void init(){
        entrenador = new Entrenador();
    }
    

  @Override
    public Entrenador getObjectByKey(Integer key) {
    return entrenadorEJB.find(key);
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
    
           public List<Entrenador> listarEntrenador(){
        return entrenadorEJB.findAll();
    }
      
       
    public void creaEntrenador(){
        try {
           entrenadorEJB.create(entrenador);
        } catch (Exception e) {
        }
    }
    
}
