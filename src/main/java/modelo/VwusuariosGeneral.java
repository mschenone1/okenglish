/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "vwusuarios_general")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwusuariosGeneral.findAll", query = "SELECT v FROM VwusuariosGeneral v"),
    @NamedQuery(name = "VwusuariosGeneral.findByIdUsuario", query = "SELECT v FROM VwusuariosGeneral v WHERE v.idUsuario = :idUsuario"),
    @NamedQuery(name = "VwusuariosGeneral.findByPassword", query = "SELECT v FROM VwusuariosGeneral v WHERE v.password = :password"),
    @NamedQuery(name = "VwusuariosGeneral.findByIdRol", query = "SELECT v FROM VwusuariosGeneral v WHERE v.idRol = :idRol"),
    @NamedQuery(name = "VwusuariosGeneral.findByLogin", query = "SELECT v FROM VwusuariosGeneral v WHERE v.login = :login"),
    @NamedQuery(name = "VwusuariosGeneral.findByPreguntaSec", query = "SELECT v FROM VwusuariosGeneral v WHERE v.preguntaSec = :preguntaSec"),
    @NamedQuery(name = "VwusuariosGeneral.findByRespuesta", query = "SELECT v FROM VwusuariosGeneral v WHERE v.respuesta = :respuesta")})
public class VwusuariosGeneral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRol")
    private int idRol;
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

    public VwusuariosGeneral() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
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
    
}
