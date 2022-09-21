/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 * Clase: Entidad Alumnos
 *
 * @author Marco Schenone
 */
public class Alumnos {

    private Integer idAlumno;
    private String tipoDoc;
    private String numDoc;
    private String apePaterno;
    private String apeMaterno;
    private String nombres;
    private String telefono;
    private String celular;
    private String email;
    private Date fecNac;
    private String sexo;
    private String usuario;

    /**
     * Metodo constructor por defecto
     */
    public Alumnos() {
    }

    /**
     * Metodo constructor
     *
     * @param idAlumno identificador del alumno
     */
    public Alumnos(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    /**
     * Metodo constructor parametrizado
     *
     * @param idAlumno identificador de la tabla
     * @param tipoDoc tipo de documento D por DNI, C por carnet de estrangeria
     * @param numDoc Numero del documento
     * @param apePaterno Apellido paterno
     * @param apeMaterno Apellido materno
     * @param nombres Nombres
     * @param telefono telefono
     * @param celular Celular
     * @param email Correo electronico
     * @param fecNac Fecha de nacimiento
     * @param sexo Sexo
     * @param usuario Nombre de usuario clave foranea
     */
    public Alumnos(Integer idAlumno, String tipoDoc, String numDoc,
            String apePaterno, String apeMaterno, String nombres,
            String telefono, String celular, String email, Date fecNac,
            String sexo, String usuario) {
        this.idAlumno = idAlumno;
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
        this.usuario = usuario;
    }

    /**
     * Metodo para regresar el numero de id del alumno
     *
     * @return Regresa el numero del id
     */
    public Integer getIdAlumno() {
        return idAlumno;
    }

    /**
     * Establece el numero id del alumno
     *
     * @param idadmin Numero que se le asignara al alumno
     */
    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    /**
     * Metodo para regresar el tipo de documento
     *
     * @return Regresa el tipo de documento
     */
    public String getTipoDoc() {
        return tipoDoc;
    }

    /**
     * Establece el tipo de documento
     *
     * @param tipoDoc tipo de documento que se asignara
     */
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    /**
     * Metodo para regresar el numero de documento
     *
     * @return Regresa el numero de documento
     */
    public String getNumDoc() {
        return numDoc;
    }

    /**
     * Establece el numero de documento
     *
     * @param numDoc numero de documento que se asignara al alumno
     */
    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    /**
     * Metodo para regresar el apellido paterno
     *
     * @return Regresa el apellido paterno
     */
    public String getApePaterno() {
        return apePaterno;
    }

    /**
     * Establece el apellido paterno
     *
     * @param apePaterno apellido paterno que se asignara al alumno
     */
    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    /**
     * Metodo para regresar el apellido materno
     *
     * @return Regresa el apellido materno
     */
    public String getApeMaterno() {
        return apeMaterno;
    }

    /**
     * Establece el apellido materno
     *
     * @param apeMaterno apellido materno que se asignara al alumno
     */
    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    /**
     * Metodo para regresar el nombre
     *
     * @return Regresa los nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece el nombre
     *
     * @param nombres nombres que se asignara al alumno
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Metodo para regresar el telefono
     *
     * @return Regresa el telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el telefono
     *
     * @param telefono telefono que se asignara al alumno
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo para regresar el celular
     *
     * @return Regresa el celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Establece el celular
     *
     * @param celular celular que se asignara al alumno
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Metodo para regresar el email
     *
     * @return Regresa el email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email
     *
     * @param email email que se asignara al alumno
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo para regresar la fecha de nacimiento
     *
     * @return Regresa la fecha de nacimiento
     */
    public Date getFecNac() {
        return fecNac;
    }

    /**
     * Establece la fecha de nacimiento
     *
     * @param fecNac fecha de nacimiento que se asignara al alumno
     */
    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    /**
     * Metodo para regresar el sexo
     *
     * @return Regresa el sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo
     *
     * @param sexo el sexo que se asignara al alumno
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Metodo para regresar el usuario
     *
     * @return Regresa el usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario
     *
     * @param usuario usuario que se asignara al alumno
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
