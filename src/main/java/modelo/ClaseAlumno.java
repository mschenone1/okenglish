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
public class ClaseAlumno implements Serializable {

    private Integer idClaseAlumno;
    private Integer idAlumno;
    private Integer idClase;

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

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

}
