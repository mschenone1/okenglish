/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author msche
 */
public class Persona {

    protected Integer id;
    protected String tipoDoc;
    protected String numDoc;
    protected String apePaterno;
    protected String apeMaterno;
    protected String nombres;
    protected String telefono;
    protected String celular;
    protected String email;
    protected Date fecNac;
    protected String sexo;
    protected String usuario;

    public Persona() {
    }

    public Persona(Integer id, String tipoDoc, String numDoc, String apePaterno, String apeMaterno, String nombres, String telefono, String celular, String email, Date fecNac, String sexo, String usuario) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    
}
