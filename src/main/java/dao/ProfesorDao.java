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
import modelo.Profesores;
import util.MySQLConexion;
/**
 *
 * @author msche
 */
public class ProfesorDao implements iDao<Profesores, String> {

    @Override
    public Optional<Profesores> encontrar(String id) throws SQLException {
        Connection conn = null;
        String tipodoc = "", num_doc = "", apePaterno = "", apeMaterno = "",
                nombres = "", telefono = "", celular = "", email = "", sexo = "";
        Date fecNac = new Date();
        int idprofesor = 0;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT idprofesor, tipo_doc, num_doc, apePaterno, \n"
                    + "apeMaterno, nombres, telefono, celular, email, fecNac, sexo\n"
                    + "FROM profesores WHERE idprofesor = ?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                idprofesor = rs.getInt("idprofesor");
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
        return Optional.of(new Profesores(idprofesor, tipodoc, num_doc, apePaterno,
                apeMaterno, nombres, telefono, celular, email, fecNac, sexo));
    }

    @Override
    public List<Profesores> encontrarTodos() throws SQLException {
        List<Profesores> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT idprofesor, tipo_doc, num_doc, apePaterno, \n"
                    + "apeMaterno, nombres, telefono, celular, email, fecNac, sexo\n"
                    + "FROM profesores";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Profesores ad = new Profesores();
                ad.setIdprofesor(rs.getInt("idprofesor"));
                ad.setTipoDoc(rs.getString("tipo_doc"));
                ad.setNumDoc(rs.getString("num_doc"));
                ad.setApePaterno(rs.getString("apePaterno"));
                ad.setApeMaterno(rs.getString("apeMaterno"));
                ad.setNombres(rs.getString("nombres"));
                ad.setTelefono(rs.getString("telefono"));
                ad.setCelular(rs.getString("celular"));
                ad.setEmail(rs.getString("email"));
                ad.setFecNac(rs.getDate("fecNac"));
                ad.setSexo(rs.getString("sexo"));

                lis.add(ad);
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
    public boolean insertar(Profesores ad) throws SQLException {
        Connection conn = null;
        boolean inserto = false;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "INSERT INTO profesores (null, tipo_doc, num_doc, apePaterno,\n"
                    + "apeMaterno, nombres, telefono, celular, email, fecNac, sexo)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, ad.getTipoDoc());
            st.setString(2, ad.getNumDoc());
            st.setString(3, ad.getApePaterno());
            st.setString(4, ad.getApeMaterno());
            st.setString(5, ad.getNombres());
            st.setString(6, ad.getTelefono());
            st.setString(7, ad.getCelular());
            st.setString(8, ad.getEmail());
            st.setDate(9, (java.sql.Date) ad.getFecNac());
            st.setString(10, ad.getSexo());
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
    public boolean actualizar(Profesores ad) throws SQLException {
        Connection conn = null;
        boolean actualizo = false;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "UPDATE profesores SET tipo_doc = ?, num_doc = ?, apePaterno = ?,\n"
                    + " apeMaterno = ?, nombres = ?, telefono = ?, celular = ?,\n"
                    + " email = ?, fecNac = ?, sexo = ? WHERE idprofesor = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, ad.getTipoDoc());
            st.setString(2, ad.getNumDoc());
            st.setString(3, ad.getApePaterno());
            st.setString(4, ad.getApeMaterno());
            st.setString(5, ad.getNombres());
            st.setString(6, ad.getTelefono());
            st.setString(7, ad.getCelular());
            st.setString(8, ad.getEmail());
            st.setDate(9, (java.sql.Date) ad.getFecNac());
            st.setString(10, ad.getSexo());
            st.setInt(11, ad.getIdprofesor());
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
    public boolean borrar(Profesores ad) throws SQLException {
        Connection conn = null;
        boolean borro = false;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "DELETE FROM  profesores WHERE idprofesor = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, ad.getIdprofesor());
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
