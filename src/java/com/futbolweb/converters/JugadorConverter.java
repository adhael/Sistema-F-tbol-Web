/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.converters;

import com.futbolweb.backend.entities.Jugador;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cristian Suesca
 */

@FacesConverter (forClass = Jugador.class)
public class JugadorConverter extends AbstractConverter{
    public JugadorConverter(){
    this.nameManagedBean = "jugadorManagedBean";
    }
}

