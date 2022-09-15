/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author msche
 */
@Entity
@Table(name = "administradores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administradores.findAll", query = "SELECT a FROM Administradores a"),
    @NamedQuery(name = "Administradores.findByIdadmin", query = "SELECT a FROM Administradores a WHERE a.idadmin = :idadmin"),
    @NamedQuery(name = "Administradores.findByTipoDoc", query = "SELECT a FROM Administradores a WHERE a.tipoDoc = :tipoDoc"),
    @NamedQuery(name = "Administradores.findByNumDoc", query = "SELECT a FROM Administradores a WHERE a.numDoc = :numDoc"),
    @NamedQuery(name = "Administradores.findByApePaterno", query = "SELECT a FROM Administradores a WHERE a.apePaterno = :apePaterno"),
    @NamedQuery(name = "Administradores.findByApeMaterno", query = "SELECT a FROM Administradores a WHERE a.apeMaterno = :apeMaterno"),
    @NamedQuery(name = "Administradores.findByNombres", query = "SELECT a FROM Administradores a WHERE a.nombres = :nombres"),
    @NamedQuery(name = "Administradores.findByTelefono", query = "SELECT a FROM Administradores a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "Administradores.findByCelular", query = "SELECT a FROM Administradores a WHERE a.celular = :celular"),
    @NamedQuery(name = "Administradores.findByEmail", query = "SELECT a FROM Administradores a WHERE a.email = :email"),
    @NamedQuery(name = "Administradores.findByFecNac", query = "SELECT a FROM Administradores a WHERE a.fecNac = :fecNac"),
    @NamedQuery(name = "Administradores.findBySexo", query = "SELECT a FROM Administradores a WHERE a.sexo = :sexo")})
public class Administradores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idadmin")
    private Integer idadmin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_doc")
    private Character tipoDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "num_doc")
    private String numDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apePaterno")
    private String apePaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apeMaterno")
    private String apeMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "celular")
    private String celular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecNac")
    @Temporal(TemporalType.DATE)
    private Date fecNac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sexo")
    private String sexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idadmin")
    private Collection<UsuariosAdministradores> usuariosAdministradoresCollection;

    public Administradores() {
    }

    public Administradores(Integer idadmin) {
        this.idadmin = idadmin;
    }

    public Administradores(Integer idadmin, Character tipoDoc, String numDoc, String apePaterno, String apeMaterno, String nombres, String telefono, String celular, String email, Date fecNac, String sexo) {
        this.idadmin = idadmin;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nombres = nombres;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.fecNac = fecNac;
        this.sexo = sexo;
    }

    public Integer getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Integer idadmin) {
        this.idadmin = idadmin;
    }

    public Character getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(Character tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
        hash += (idadmin != null ? idadmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administradores)) {
            return false;
        }
        Administradores other = (Administradores) object;
        if ((this.idadmin == null && other.idadmin != null) || (this.idadmin != null && !this.idadmin.equals(other.idadmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Administradores[ idadmin=" + idadmin + " ]";
    }
    
}
