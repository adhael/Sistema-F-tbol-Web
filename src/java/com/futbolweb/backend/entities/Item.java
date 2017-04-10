/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByIdItems", query = "SELECT i FROM Item i WHERE i.idItems = :idItems"),
    @NamedQuery(name = "Item.findByCantidadItems", query = "SELECT i FROM Item i WHERE i.cantidadItems = :cantidadItems")})
public class Item implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_items")
    private Integer idItems;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_items")
    private int cantidadItems;
    @JoinColumn(name = "id_valoracion", referencedColumnName = "id_valoracion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Valoracion idValoracion;
    @JoinColumn(name = "id_desempenio", referencedColumnName = "id_desempenio")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Desempenio idDesempenio;

    public Item() {
    }

    public Item(Integer idItems) {
        this.idItems = idItems;
    }

    public Item(Integer idItems, int cantidadItems) {
        this.idItems = idItems;
        this.cantidadItems = cantidadItems;
    }

    public Integer getIdItems() {
        return idItems;
    }

    public void setIdItems(Integer idItems) {
        this.idItems = idItems;
    }

    public int getCantidadItems() {
        return cantidadItems;
    }

    public void setCantidadItems(int cantidadItems) {
        this.cantidadItems = cantidadItems;
    }

    public Valoracion getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(Valoracion idValoracion) {
        this.idValoracion = idValoracion;
    }

    public Desempenio getIdDesempenio() {
        return idDesempenio;
    }

    public void setIdDesempenio(Desempenio idDesempenio) {
        this.idDesempenio = idDesempenio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItems != null ? idItems.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.idItems == null && other.idItems != null) || (this.idItems != null && !this.idItems.equals(other.idItems))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.futbolweb.backend.entities.Item[ idItems=" + idItems + " ]";
    }

    @Override
    public String obtenerLlavePrimaria() {
        return idItems.toString();
    }
    
}
