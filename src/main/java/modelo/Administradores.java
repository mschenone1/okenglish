/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 * Clase: Entidad Administradores
 *
 * @author Marco Schenone
 */
public class Administradores extends Persona {

    /**
     * Metodo constructor por defecto
     */
    public Administradores() {
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
    public Administradores(Integer id, String tipoDoc, String numDoc, String apePaterno, String apeMaterno, String nombres, String telefono, String celular, String email, Date fecNac, String sexo, String usuario) {
        super(id, tipoDoc, numDoc, apePaterno, apeMaterno, nombres, telefono, celular, email, fecNac, sexo, usuario);
    }

}
