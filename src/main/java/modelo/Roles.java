/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author msche
 */
@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByIdRol", query = "SELECT r FROM Roles r WHERE r.idRol = :idRol"),
    @NamedQuery(name = "Roles.findByNomRol", query = "SELECT r FROM Roles r WHERE r.nomRol = :nomRol")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRol")
    private Integer idRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomRol")
    private String nomRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private Collection<UsuariosProfesores> usuariosProfesoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private Collection<UsuariosAlumnos> usuariosAlumnosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private Collection<UsuariosAdministradores> usuariosAdministradoresCollection;

    public Roles() {
    }

    public Roles(Integer idRol) {
        this.idRol = idRol;
    }

    public Roles(Integer idRol, String nomRol) {
        this.idRol = idRol;
        this.nomRol = nomRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    @XmlTransient
    public Collection<UsuariosProfesores> getUsuariosProfesoresCollection() {
        return usuariosProfesoresCollection;
    }

    public void setUsuariosProfesoresCollection(Collection<UsuariosProfesores> usuariosProfesoresCollection) {
        this.usuariosProfesoresCollection = usuariosProfesoresCollection;
    }

    @XmlTransient
    public Collection<UsuariosAlumnos> getUsuariosAlumnosCollection() {
        return usuariosAlumnosCollection;
    }

    public void setUsuariosAlumnosCollection(Collection<UsuariosAlumnos> usuariosAlumnosCollection) {
        this.usuariosAlumnosCollection = usuariosAlumnosCollection;
    }

    @XmlTransient
    public Collection<UsuariosAdministradores> getUsuariosAdministradoresCollection() {
        return usuariosAdministradoresCollection;
    }

    public void setUsuariosAdministradoresCollection(Collection<UsuariosAdministradores> usuariosAdministradoresCollection) {
        this.usuariosAdministradoresCollection = usuariosAdministradoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Roles[ idRol=" + idRol + " ]";
    }
    
}
