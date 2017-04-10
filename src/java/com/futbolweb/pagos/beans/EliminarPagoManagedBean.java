/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.pagos.beans;

import com.futbolweb.backend.entities.Pago;
import com.futbolweb.backend.facade.PagoFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Felipe
 */
@Named(value = "eliminarPagoManagedBean")
@RequestScoped
public class EliminarPagoManagedBean {

     private Pago pago;
    @EJB 
    private PagoFacade pagof;
    
    
    @PostConstruct
    public void init(){
    pago = new Pago();
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
    
    public void eliminarPago(Pago p){
    pagof.remove(p);
    }
    /**
     * Creates a new instance of EliminarPagoManagedBean
     */
    public EliminarPagoManagedBean() {
    }
    
}
