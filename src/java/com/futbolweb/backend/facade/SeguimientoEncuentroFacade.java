/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.backend.facade;

import com.futbolweb.backend.entities.SeguimientoEncuentro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe
 */
@Stateless
public class SeguimientoEncuentroFacade extends AbstractFacade<SeguimientoEncuentro> {

    @PersistenceContext(unitName = "sistema_futbol_webPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeguimientoEncuentroFacade() {
        super(SeguimientoEncuentro.class);
    }
    
}
