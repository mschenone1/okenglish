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
@Table(name = "horarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarios.findAll", query = "SELECT h FROM Horarios h"),
    @NamedQuery(name = "Horarios.findByIdHorario", query = "SELECT h FROM Horarios h WHERE h.idHorario = :idHorario"),
    @NamedQuery(name = "Horarios.findByDescHorario", query = "SELECT h FROM Horarios h WHERE h.descHorario = :descHorario"),
    @NamedQuery(name = "Horarios.findByHoraInicio", query = "SELECT h FROM Horarios h WHERE h.horaInicio = :horaInicio"),
    @NamedQuery(name = "Horarios.findByHoraFin", query = "SELECT h FROM Horarios h WHERE h.horaFin = :horaFin"),
    @NamedQuery(name = "Horarios.findByHorarioImg", query = "SELECT h FROM Horarios h WHERE h.horarioImg = :horarioImg")})
public class Horarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHorario")
    private Integer idHorario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descHorario")
    private String descHorario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaInicio")
    private int horaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaFin")
    private int horaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "horarioImg")
    private String horarioImg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHorario")
    private Collection<Clase> claseCollection;

    public Horarios() {
    }

    public Horarios(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Horarios(Integer idHorario, String descHorario, int horaInicio, int horaFin, String horarioImg) {
        this.idHorario = idHorario;
        this.descHorario = descHorario;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.horarioImg = horarioImg;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getDescHorario() {
        return descHorario;
    }

    public void setDescHorario(String descHorario) {
        this.descHorario = descHorario;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public String getHorarioImg() {
        return horarioImg;
    }

    public void setHorarioImg(String horarioImg) {
        this.horarioImg = horarioImg;
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
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) object;
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Horarios[ idHorario=" + idHorario + " ]";
    }
    
}
