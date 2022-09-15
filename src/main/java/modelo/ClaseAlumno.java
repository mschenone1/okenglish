/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author msche
 */
@Entity
@Table(name = "clase_alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClaseAlumno.findAll", query = "SELECT c FROM ClaseAlumno c"),
    @NamedQuery(name = "ClaseAlumno.findByIdClaseAlumno", query = "SELECT c FROM ClaseAlumno c WHERE c.idClaseAlumno = :idClaseAlumno")})
public class ClaseAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idClaseAlumno")
    private Integer idClaseAlumno;
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumnos idalumno;
    @JoinColumn(name = "idClase", referencedColumnName = "idClase")
    @ManyToOne(optional = false)
    private Clase idClase;

    public ClaseAlumno() {
    }

    public ClaseAlumno(Integer idClaseAlumno) {
        this.idClaseAlumno = idClaseAlumno;
    }

    public Integer getIdClaseAlumno() {
        return idClaseAlumno;
    }

    public void setIdClaseAlumno(Integer idClaseAlumno) {
        this.idClaseAlumno = idClaseAlumno;
    }

    public Alumnos getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumnos idalumno) {
        this.idalumno = idalumno;
    }

    public Clase getIdClase() {
        return idClase;
    }

    public void setIdClase(Clase idClase) {
        this.idClase = idClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClaseAlumno != null ? idClaseAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClaseAlumno)) {
            return false;
        }
        ClaseAlumno other = (ClaseAlumno) object;
        if ((this.idClaseAlumno == null && other.idClaseAlumno != null) || (this.idClaseAlumno != null && !this.idClaseAlumno.equals(other.idClaseAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ClaseAlumno[ idClaseAlumno=" + idClaseAlumno + " ]";
    }
    
}
