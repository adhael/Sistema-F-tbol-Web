/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.backend.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByIdTipoRol", query = "SELECT r FROM Rol r WHERE r.idTipoRol = :idTipoRol"),
    @NamedQuery(name = "Rol.findByNombreRol", query = "SELECT r FROM Rol r WHERE r.nombreRol = :nombreRol")})
public class Rol implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_rol")
    private Integer idTipoRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_rol")
    private String nombreRol;
    @JoinTable(name = "roles_permisos", joinColumns = {
        @JoinColumn(name = "id_rol", referencedColumnName = "id_tipo_rol")}, inverseJoinColumns = {
        @JoinColumn(name = "id_permiso", referencedColumnName = "id_permiso")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Permiso> permisoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoRol", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;

    public Rol() {
    }

    public Rol(Integer idTipoRol) {
        this.idTipoRol = idTipoRol;
    }

    public Rol(Integer idTipoRol, String nombreRol) {
        this.idTipoRol = idTipoRol;
        this.nombreRol = nombreRol;
    }

    public Integer getIdTipoRol() {
        return idTipoRol;
    }

    public void setIdTipoRol(Integer idTipoRol) {
        this.idTipoRol = idTipoRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoRol != null ? idTipoRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idTipoRol == null && other.idTipoRol != null) || (this.idTipoRol != null && !this.idTipoRol.equals(other.idTipoRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.futbolweb.backend.entities.Rol[ idTipoRol=" + idTipoRol + " ]";
    }

    @Override
    public String obtenerLlavePrimaria() {
        return idTipoRol.toString();
    }
    
}
