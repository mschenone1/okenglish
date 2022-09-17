/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author msche
 * @param <T>
 * @param <ID>
 */
public interface iDao<T, ID> {

    Optional<T> encontrar(ID id) throws SQLException;

    List<T> encontrarTodos() throws SQLException;

    boolean insertar(T o) throws SQLException;

    boolean actualizar(T o) throws SQLException;

    boolean borrar(T o) throws SQLException;

}
