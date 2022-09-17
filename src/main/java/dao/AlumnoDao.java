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
 *
 * @author msche
 */
public class AlumnoDao implements iDao<Alumnos, String> {

    @Override
    public Optional<Alumnos> encontrar(String id) throws SQLException {

        Connection conn = null;
        String tipodoc = "", num_doc = "", apePaterno = "", apeMaterno = "",
                nombres = "", telefono = "", celular = "", email = "", sexo = "";
        Date fecNac = new Date();
        int idalumno = 0;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT idalumno, tipo_doc, num_doc, apePaterno, \n"
                    + "apeMaterno, nombres, telefono, celular, email, fecNac, sexo\n"
                    + "FROM alumnos WHERE idalumno = ?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                idalumno = rs.getInt("idalumno");
                tipodoc = rs.getString("tipo_doc");
                num_doc = rs.getString("num_doc");
                apePaterno = rs.getString("apePaterno");
                apeMaterno = rs.getString("apeMaterno");
                nombres = rs.getString("nombres");
                telefono = rs.getString("telefono");
                celular = rs.getString("celular");
                email = rs.getString("email");
                fecNac = rs.getDate("fecNac");
                sexo = rs.getString("sexo");

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
        return Optional.of(new Alumnos(idalumno, tipodoc, num_doc, apePaterno,
                apeMaterno, nombres, telefono, celular, email, fecNac, sexo));
    }

    @Override
    public List<Alumnos> encontrarTodos() throws SQLException {
        List<Alumnos> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT idalumno, tipo_doc, num_doc, apePaterno, \n"
                    + "apeMaterno, nombres, telefono, celular, email, fecNac, sexo\n"
                    + "FROM alumnos";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Alumnos al = new Alumnos();
                al.setIdalumno(rs.getInt("idalumno"));
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

    @Override
    public boolean insertar(Alumnos al) throws SQLException {
        Connection conn = null;
        boolean inserto = false;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "INSERT INTO alumnos (null, tipo_doc, num_doc, apePaterno,\n"
                    + "apeMaterno, nombres, telefono, celular, email, fecNac, sexo)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

    @Override
    public boolean actualizar(Alumnos al) throws SQLException {
        Connection conn = null;
        boolean actualizo = false;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "UPDATE alumnos SET tipo_doc = ?, num_doc = ?, apePaterno = ?,\n"
                    + " apeMaterno = ?, nombres = ?, telefono = ?, celular = ?,\n"
                    + " email = ?, fecNac = ?, sexo = ? WHERE idalumno = ?";
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
            st.setInt(11, al.getIdalumno());
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

    @Override
    public boolean borrar(Alumnos al) throws SQLException {
        Connection conn = null;
        boolean borro = false;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "DELETE FROM  alumnos WHERE idalumno = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, al.getIdalumno());
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