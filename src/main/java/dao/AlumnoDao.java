/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Date;
import modelo.Alumnos;
import util.MySQLConexion;
import java.lang.String;
import java.util.ArrayList;

/**
 * Clase: Objeto de acceso a datos de Alumnos
 *
 * @author Marco Schenone
 */
public class AlumnoDao implements iDao<Alumnos, Integer> {

    /**
     * Metodo para encontrar un alumno por id
     *
     * @param id
     * @return uno objeto alumno
     * @throws SQLException
     */
    @Override
    public Alumnos encontrar(Integer id) throws SQLException {

        Connection conn = null;
        Alumnos al = new Alumnos();

        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT idalumno, tipo_doc, num_doc, apePaterno, \n"
                    + "apeMaterno, nombres, telefono, celular, email, fecNac, sexo\n"
                    + ", usuario FROM alumnos WHERE idalumno = ?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                al.setId(rs.getInt("idalumno"));
                al.setTipoDoc(rs.getString("tipo_doc"));
                al.setNumDoc(rs.getString("num_doc"));
                al.setApePaterno(rs.getString("apePaterno"));
                al.setApeMaterno(rs.getString("apeMaterno"));
                al.setNombres(rs.getString("nombres"));
                al.setTelefono(rs.getString("telefono"));
                al.setCelular(rs.getString("celular"));
                al.setEmail(rs.getString("email"));
                al.setFecNac(rs.getDate("fecNac"));
                al.setSexo(rs.getString("sexo"));
                al.setUsuario(rs.getString("usuario"));

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
        return al;
    }

    /**
     * Metodo para encontrar a todos los alumnoes
     *
     * @param id
     * @return una lista de objetos alumno
     * @throws SQLException
     */
    @Override
    public List<Alumnos> encontrarTodos() throws SQLException {
        List<Alumnos> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT idalumno, tipo_doc, num_doc, apePaterno, \n"
                    + "apeMaterno, nombres, telefono, celular, email, fecNac, sexo\n"
                    + ", usuario FROM alumnos";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Alumnos al = new Alumnos();
                al.setId(rs.getInt("idalumno"));
                al.setTipoDoc(rs.getString("tipo_doc"));
                al.setNumDoc(rs.getString("num_doc"));
                al.setApePaterno(rs.getString("apePaterno"));
                al.setApeMaterno(rs.getString("apeMaterno"));
                al.setNombres(rs.getString("nombres"));
                al.setTelefono(rs.getString("telefono"));
                al.setCelular(rs.getString("celular"));
                al.setEmail(rs.getString("email"));
                al.setFecNac(rs.getDate("fecNac"));
                al.setSexo(rs.getString("sexo"));
                al.setUsuario(rs.getString("usuario"));

                lis.add(al);
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

    /**
     * Metodo para Insertar un alumno
     *
     * @param ad objeto alumno
     * @return inserto boolean
     * @throws SQLException
     */
    @Override
    public boolean insertar(Alumnos al) throws SQLException {
        Connection conn = null;
        boolean inserto = false;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "INSERT INTO alumnos (null, tipo_doc, num_doc, apePaterno,\n"
                    + "apeMaterno, nombres, telefono, celular, email, fecNac, sexo)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, al.getTipoDoc());
            st.setString(2, al.getNumDoc());
            st.setString(3, al.getApePaterno());
            st.setString(4, al.getApeMaterno());
            st.setString(5, al.getNombres());
            st.setString(6, al.getTelefono());
            st.setString(7, al.getCelular());
            st.setString(8, al.getEmail());
            st.setDate(9, (java.sql.Date) al.getFecNac());
            st.setString(10, al.getSexo());
            st.setString(11, al.getUsuario());
            inserto = st.executeUpdate() > 0;
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
        return inserto;
    }

    /**
     * Metodo para Actualizar un alumno
     *
     * @param ad objeto alumno
     * @return actualizo boolean
     * @throws SQLException
     */
    @Override
    public boolean actualizar(Alumnos al) throws SQLException {
        Connection conn = null;
        boolean actualizo = false;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "UPDATE alumnos SET tipo_doc = ?, num_doc = ?, apePaterno = ?,\n"
                    + " apeMaterno = ?, nombres = ?, telefono = ?, celular = ?,\n"
                    + " email = ?, fecNac = ?, sexo = ?, usuario = ? WHERE idalumno = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, al.getTipoDoc());
            st.setString(2, al.getNumDoc());
            st.setString(3, al.getApePaterno());
            st.setString(4, al.getApeMaterno());
            st.setString(5, al.getNombres());
            st.setString(6, al.getTelefono());
            st.setString(7, al.getCelular());
            st.setString(8, al.getEmail());
            st.setDate(9, (java.sql.Date) al.getFecNac());
            st.setString(10, al.getSexo());
            st.setString(11, al.getUsuario());
            st.setInt(12, al.getId());
            actualizo = st.executeUpdate() > 0;
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
        return actualizo;
    }

    /**
     * Metodo para Borrar un alumno
     *
     * @param ad objeto alumno
     * @return borro boolean
     * @throws SQLException
     */
    @Override
    public boolean borrar(Alumnos al) throws SQLException {
        Connection conn = null;
        boolean borro = false;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "DELETE FROM  alumnos WHERE idalumno = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, al.getId());
            borro = st.executeUpdate() > 0;
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
        return borro;
    }

}
