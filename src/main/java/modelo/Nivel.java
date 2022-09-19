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
public class Nivel {

    private Integer idNivel;
    private String nomNivel;
    private String nomLibro;
    private String linkLibro;

    public Nivel() {
    }

    public Nivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Nivel(Integer idNivel, String nomNivel, String nomLibro, String linkLibro) {
        this.idNivel = idNivel;
        this.nomNivel = nomNivel;
        this.nomLibro = nomLibro;
        this.linkLibro = linkLibro;
    }

    public Integer getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public String getNomNivel() {
        return nomNivel;
    }

    public void setNomNivel(String nomNivel) {
        this.nomNivel = nomNivel;
    }

    public String getNomLibro() {
        return nomLibro;
    }

    public void setNomLibro(String nomLibro) {
        this.nomLibro = nomLibro;
    }

    public String getLinkLibro() {
        return linkLibro;
    }

    public void setLinkLibro(String linkLibro) {
        this.linkLibro = linkLibro;
    }

}
