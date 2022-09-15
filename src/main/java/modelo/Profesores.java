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
@Table(name = "profesores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesores.findAll", query = "SELECT p FROM Profesores p"),
    @NamedQuery(name = "Profesores.findByIdprofesor", query = "SELECT p FROM Profesores p WHERE p.idprofesor = :idprofesor"),
    @NamedQuery(name = "Profesores.findByTipoDoc", query = "SELECT p FROM Profesores p WHERE p.tipoDoc = :tipoDoc"),
    @NamedQuery(name = "Profesores.findByNumDoc", query = "SELECT p FROM Profesores p WHERE p.numDoc = :numDoc"),
    @NamedQuery(name = "Profesores.findByApePaterno", query = "SELECT p FROM Profesores p WHERE p.apePaterno = :apePaterno"),
    @NamedQuery(name = "Profesores.findByApeMaterno", query = "SELECT p FROM Profesores p WHERE p.apeMaterno = :apeMaterno"),
    @NamedQuery(name = "Profesores.findByNombres", query = "SELECT p FROM Profesores p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Profesores.findByTelefono", query = "SELECT p FROM Profesores p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Profesores.findByCelular", query = "SELECT p FROM Profesores p WHERE p.celular = :celular"),
    @NamedQuery(name = "Profesores.findByEmail", query = "SELECT p FROM Profesores p WHERE p.email = :email"),
    @NamedQuery(name = "Profesores.findByFecNac", query = "SELECT p FROM Profesores p WHERE p.fecNac = :fecNac"),
    @NamedQuery(name = "Profesores.findBySexo", query = "SELECT p FROM Profesores p WHERE p.sexo = :sexo")})
public class Profesores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprofesor")
    private Integer idprofesor;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesor")
    private Collection<UsuariosProfesores> usuariosProfesoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesor")
    private Collection<Clase> claseCollection;

    public Profesores() {
    }

    public Profesores(Integer idprofesor) {
        this.idprofesor = idprofesor;
    }

    public Profesores(Integer idprofesor, Character tipoDoc, String numDoc, String apePaterno, String apeMaterno, String nombres, String telefono, String celular, String email, Date fecNac, String sexo) {
        this.idprofesor = idprofesor;
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

    public Integer getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Integer idprofesor) {
        this.idprofesor = idprofesor;
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
    public Collection<UsuariosProfesores> getUsuariosProfesoresCollection() {
        return usuariosProfesoresCollection;
    }

    public void setUsuariosProfesoresCollection(Collection<UsuariosProfesores> usuariosProfesoresCollection) {
        this.usuariosProfesoresCollection = usuariosProfesoresCollection;
    }

    @XmlTransient
    public Collection<Clase> getClaseCollection() {
        return claseCollection;
    }

    public void setClaseCollection(Collection<Clase> claseCollection) {
        this.claseCollection = claseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofesor != null ? idprofesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesores)) {
            return false;
        }
        Profesores other = (Profesores) object;
        if ((this.idprofesor == null && other.idprofesor != null) || (this.idprofesor != null && !this.idprofesor.equals(other.idprofesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Profesores[ idprofesor=" + idprofesor + " ]";
    }
    
}
