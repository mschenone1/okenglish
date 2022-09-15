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
@Table(name = "alumnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumnos.findAll", query = "SELECT a FROM Alumnos a"),
    @NamedQuery(name = "Alumnos.findByIdalumno", query = "SELECT a FROM Alumnos a WHERE a.idalumno = :idalumno"),
    @NamedQuery(name = "Alumnos.findByTipoDoc", query = "SELECT a FROM Alumnos a WHERE a.tipoDoc = :tipoDoc"),
    @NamedQuery(name = "Alumnos.findByNumDoc", query = "SELECT a FROM Alumnos a WHERE a.numDoc = :numDoc"),
    @NamedQuery(name = "Alumnos.findByApePaterno", query = "SELECT a FROM Alumnos a WHERE a.apePaterno = :apePaterno"),
    @NamedQuery(name = "Alumnos.findByApeMaterno", query = "SELECT a FROM Alumnos a WHERE a.apeMaterno = :apeMaterno"),
    @NamedQuery(name = "Alumnos.findByNombres", query = "SELECT a FROM Alumnos a WHERE a.nombres = :nombres"),
    @NamedQuery(name = "Alumnos.findByTelefono", query = "SELECT a FROM Alumnos a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "Alumnos.findByCelular", query = "SELECT a FROM Alumnos a WHERE a.celular = :celular"),
    @NamedQuery(name = "Alumnos.findByEmail", query = "SELECT a FROM Alumnos a WHERE a.email = :email"),
    @NamedQuery(name = "Alumnos.findByFecNac", query = "SELECT a FROM Alumnos a WHERE a.fecNac = :fecNac"),
    @NamedQuery(name = "Alumnos.findBySexo", query = "SELECT a FROM Alumnos a WHERE a.sexo = :sexo")})
public class Alumnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idalumno")
    private Integer idalumno;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumno")
    private Collection<ClaseAlumno> claseAlumnoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumno")
    private Collection<UsuariosAlumnos> usuariosAlumnosCollection;

    public Alumnos() {
    }

    public Alumnos(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public Alumnos(Integer idalumno, Character tipoDoc, String numDoc, String apePaterno, String apeMaterno, String nombres, String telefono, String celular, String email, Date fecNac, String sexo) {
        this.idalumno = idalumno;
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

    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
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
    public Collection<ClaseAlumno> getClaseAlumnoCollection() {
        return claseAlumnoCollection;
    }

    public void setClaseAlumnoCollection(Collection<ClaseAlumno> claseAlumnoCollection) {
        this.claseAlumnoCollection = claseAlumnoCollection;
    }

    @XmlTransient
    public Collection<UsuariosAlumnos> getUsuariosAlumnosCollection() {
        return usuariosAlumnosCollection;
    }

    public void setUsuariosAlumnosCollection(Collection<UsuariosAlumnos> usuariosAlumnosCollection) {
        this.usuariosAlumnosCollection = usuariosAlumnosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalumno != null ? idalumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumnos)) {
            return false;
        }
        Alumnos other = (Alumnos) object;
        if ((this.idalumno == null && other.idalumno != null) || (this.idalumno != null && !this.idalumno.equals(other.idalumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Alumnos[ idalumno=" + idalumno + " ]";
    }
    
}
