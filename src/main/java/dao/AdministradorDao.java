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
import modelo.Administradores;
import util.MySQLConexion;

/**
 *
 * @author msche
 */
public class AdministradorDao implements iDao<Administradores, Integer> {

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Administradores encontrar(Integer id) throws SQLException {
        Connection conn = null;
        Administradores ad = new Administradores();
                
        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT idadmin, tipo_doc, num_doc, apePaterno, \n"
                    + "apeMaterno, nombres, telefono, celular, email, fecNac, sexo\n"
                    + " , usuario FROM administradores WHERE idadmin = ?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ad.setIdadmin(rs.getInt("idadmin"));
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
                ad.setSexo(rs.getString("usuario"));

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
        return ad;
    }

    @Override
    public List<Administradores> encontrarTodos() throws SQLException {
        List<Administradores> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "SELECT idadmin, tipo_doc, num_doc, apePaterno, \n"
                    + "apeMaterno, nombres, telefono, celular, email, fecNac, sexo\n"
                    + ", usuario FROM administradores";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Administradores ad = new Administradores();
                ad.setIdadmin(rs.getInt("idadmin"));
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
                ad.setSexo(rs.getString("usuario"));

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
    public boolean insertar(Administradores ad) throws SQLException {
        Connection conn = null;
        boolean inserto = false;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "INSERT INTO administradores (null, tipo_doc, num_doc, apePaterno,\n"
                    + "apeMaterno, nombres, telefono, celular, email, fecNac, sexo)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            st.setString(11, ad.getUsuario());
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
    public boolean actualizar(Administradores ad) throws SQLException {
        Connection conn = null;
        boolean actualizo = false;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "UPDATE administradores SET tipo_doc = ?, num_doc = ?, apePaterno = ?,\n"
                    + " apeMaterno = ?, nombres = ?, telefono = ?, celular = ?,\n"
                    + " email = ?, fecNac = ?, sexo = ?, usuario = ? WHERE idadmin = ?";
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
            st.setString(11, ad.getUsuario());
            st.setInt(12, ad.getIdadmin());
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
    public boolean borrar(Administradores ad) throws SQLException {
        Connection conn = null;
        boolean borro = false;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "DELETE FROM  administradores WHERE idadmin = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, ad.getIdadmin());
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
