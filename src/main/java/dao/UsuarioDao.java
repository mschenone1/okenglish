/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import modelo.Alumnos;
import modelo.Usuario;
import util.MySQLConexion;

/**
 *
 * @author msche
 */
public class UsuarioDao implements iDao<Usuario, String> {

    public Usuario login(String _username, String _password) {
        Usuario d = null;
        Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "select u.usuario, u.password, u.idRol, u.enabled, r.nomRol\n"
                    + " from usuario u join roles r on u.idRol = r.idRol\n"
                    + " where u.usuario = ? and u.password = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, _username);
            st.setString(2, _password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                d = new Usuario();
                d.setUsuario(rs.getString(1));
                d.setPassword(rs.getString(2));
                d.setIdRol(Integer.parseInt(rs.getString(3)));
                d.setEnabled(rs.getInt(4));
                d.setNomRol(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return d;
    }

    @Override
    public Optional<Usuario> encontrar(String id) throws SQLException {
        Connection conn = null;
        String usuario = "", password = "";
        Date fecNac = new Date();
        int enabled = 0, idRol = 0;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT usuario, password, enabled, idRol\n"
                    + "FROM usuario WHERE usuario = ?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                usuario = rs.getString("usuario");
                password = rs.getString("password");
                enabled = rs.getInt("enabled");
                idRol = rs.getInt("idRol");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return Optional.of(new Usuario(usuario, password, enabled, idRol));
    }

    @Override
    public List<Usuario> encontrarTodos() throws SQLException {
        List<Usuario> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT usuario, password, enabled, idrol"
                    + " from usuario";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Usuario us = new Usuario();
                us.setUsuario(rs.getString("usuario"));
                us.setPassword(rs.getString("password"));
                us.setEnabled(rs.getInt("enabled"));
                us.setIdRol(rs.getInt("idrol"));

                lis.add(us);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;
    }

    @Override
    public boolean insertar(Usuario o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Usuario o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean borrar(Usuario o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
