/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.backend.facade;

import com.futbolweb.backend.entities.HorarioClub;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe
 */
@Stateless
public class HorarioClubFacade extends AbstractFacade<HorarioClub> {

    @PersistenceContext(unitName = "sistema_futbol_webPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorarioClubFacade() {
        super(HorarioClub.class);
    }
    
}
