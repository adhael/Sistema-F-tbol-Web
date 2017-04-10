/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.pagos.beans;

import com.futbolweb.backend.entities.Jugador;
import com.futbolweb.backend.entities.Pago;
import com.futbolweb.backend.facade.PagoFacade;
import com.futbolweb.beans.JugadorManagedBean;
import com.futbolweb.beans.UsuarioManagedBean;
import com.futbolweb.email.Email;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Felipe
 */
@Named(value = "registroPagoManagedBean")
@RequestScoped
public class RegistroPagoManagedBean {

    private Pago pago;
     @EJB 
    private PagoFacade pagof;
    @Inject
    private UsuarioManagedBean usuarioC;
    @Inject
    private JugadorManagedBean jugadorC;
    
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

    public UsuarioManagedBean getUsuarioC() {
        return usuarioC;
    }

    public void setUsuarioC(UsuarioManagedBean usuarioC) {
        this.usuarioC = usuarioC;
    }

    public JugadorManagedBean getJugadorC() {
        return jugadorC;
    }

    public void setJugadorC(JugadorManagedBean jugadorC) {
        this.jugadorC = jugadorC;
    }

    
    
    public void registrarPago(){
    Email envioC;
    envioC = new Email("Novedad de pago Expreso Rojo", "Se le notifíca que se le ha generado un nuevo registro de pago en el club Expreso Rojo, para mas información consultar el control de pagos en nuestro sistema :", pago.getFkIdJugador().getUsuario().getCorreo());
    envioC.enviarEmail();
    pagof.create(pago);
    }
    /**
     * Creates a new instance of RegistroPagoManagedBean
     */
    public RegistroPagoManagedBean() {
    }
    
}
