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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author msche
 */
@Entity
@Table(name = "usuarios_alumnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosAlumnos.findAll", query = "SELECT u FROM UsuariosAlumnos u"),
    @NamedQuery(name = "UsuariosAlumnos.findByIdUsuario", query = "SELECT u FROM UsuariosAlumnos u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuariosAlumnos.findByPassword", query = "SELECT u FROM UsuariosAlumnos u WHERE u.password = :password"),
    @NamedQuery(name = "UsuariosAlumnos.findByEnabled", query = "SELECT u FROM UsuariosAlumnos u WHERE u.enabled = :enabled"),
    @NamedQuery(name = "UsuariosAlumnos.findByLogin", query = "SELECT u FROM UsuariosAlumnos u WHERE u.login = :login"),
    @NamedQuery(name = "UsuariosAlumnos.findByPreguntaSec", query = "SELECT u FROM UsuariosAlumnos u WHERE u.preguntaSec = :preguntaSec"),
    @NamedQuery(name = "UsuariosAlumnos.findByRespuesta", query = "SELECT u FROM UsuariosAlumnos u WHERE u.respuesta = :respuesta")})
public class UsuariosAlumnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "preguntaSec")
    private String preguntaSec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "respuesta")
    private String respuesta;
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumnos idalumno;
    @JoinColumn(name = "idRol", referencedColumnName = "idRol")
    @ManyToOne(optional = false)
    private Roles idRol;

    public UsuariosAlumnos() {
    }

    public UsuariosAlumnos(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuariosAlumnos(Integer idUsuario, String password, boolean enabled, String login, String preguntaSec, String respuesta) {
        this.idUsuario = idUsuario;
        this.password = password;
        this.enabled = enabled;
        this.login = login;
        this.preguntaSec = preguntaSec;
        this.respuesta = respuesta;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPreguntaSec() {
        return preguntaSec;
    }

    public void setPreguntaSec(String preguntaSec) {
        this.preguntaSec = preguntaSec;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Alumnos getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumnos idalumno) {
        this.idalumno = idalumno;
    }

    public Roles getIdRol() {
        return idRol;
    }

    public void setIdRol(Roles idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosAlumnos)) {
            return false;
        }
        UsuariosAlumnos other = (UsuariosAlumnos) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.UsuariosAlumnos[ idUsuario=" + idUsuario + " ]";
    }
    
}