/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.converters;

import com.futbolweb.backend.entities.Entrenador;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cristian Suesca
 */
@FacesConverter (forClass = Entrenador.class)
public class EntrenadorConverter extends AbstractConverter{
    public EntrenadorConverter(){
    this.nameManagedBean = "entrenadorManagedBean";
    }
}
