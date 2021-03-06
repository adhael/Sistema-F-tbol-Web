/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.beans;

import com.futbolweb.backend.entities.Pago;
import com.futbolweb.backend.facade.PagoFacade;
import com.futbolweb.converters.InterfaceController;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Felipe
 */
@Named(value = "pagoManagedBean")
@RequestScoped
public class PagoManagedBean implements InterfaceController<Pago> {

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
    
    public List<Pago> listarPago() {

        return pagof.findAll();
        
    }
    
    public String actualizarPago(Pago pa){
        pago = pa;
        return "";
    }
    /**
     * Creates a new instance of PagoManagedBean
     */
    public PagoManagedBean() {
    
    }

    @Override
    public Pago getObjectByKey(Integer key) {
        return pagof.find(key);
    }
    
}
