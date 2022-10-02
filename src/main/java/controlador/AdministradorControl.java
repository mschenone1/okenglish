/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.AdministradorDao;
import dao.UsuarioDao;
import modelo.Usuario;
import modelo.Administradores;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author msche
 */
public class AdministradorControl extends HttpServlet {

    UsuarioDao daoUsuario = new UsuarioDao();
    AdministradorDao daoAdministrador = new AdministradorDao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            int op = Integer.parseInt(request.getParameter("opc"));
            switch (op) {
                case 1:
                    listar(request, response);
                    break;
                case 2:
                    insertar(request, response);
                    break;
                case 3:
                    actualizar(request, response);
                    break;
                case 4:
                    borrar(request, response);
                    break;
                case 5:
                    encontrar(request, response);
                    break;
            }
        }
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String pag = "jsp/Admin/Usuarios/Admin_admin.jsp";
        request.setAttribute("dato", daoAdministrador.encontrarTodos());
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String password = request.getParameter("password");

        Usuario u = new Usuario();
        u.setUsuario(request.getParameter("username"));
        u.setPassword(password);
        u.setIdRol(1);
        u.setEnabled(1);

        daoUsuario.insertar(u);

        Administradores d = new Administradores();

        d.setTipoDoc(request.getParameter("tipodoc"));
        d.setNumDoc(request.getParameter("numdoc"));
        d.setApePaterno(request.getParameter("apepaterno"));
        d.setApeMaterno(request.getParameter("apematerno"));
        d.setNombres(request.getParameter("nombres"));
        d.setTelefono(request.getParameter("telefono"));
        d.setCelular(request.getParameter("celular"));
        d.setEmail(request.getParameter("email"));
        //d.setFecNacimiento(new Date(request.getParameter("fecnacimiento")));
        d.setSexo(request.getParameter("sexo"));
        d.setUsuario(request.getParameter("usuario"));

        daoAdministrador.insertar(d);

        response.sendRedirect("Usuarios/Admin_admin.jsp");

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String password = request.getParameter("password");

        Usuario u = new Usuario();
        u.setUsuario(request.getParameter("username"));
        u.setPassword(password);
        u.setIdRol(1);
        u.setEnabled(1);

        daoUsuario.actualizar(u);

        Administradores d = new Administradores();

        d.setTipoDoc(request.getParameter("tipodoc"));
        d.setNumDoc(request.getParameter("numdoc"));
        d.setApePaterno(request.getParameter("apepaterno"));
        d.setApeMaterno(request.getParameter("apematerno"));
        d.setNombres(request.getParameter("nombres"));
        d.setTelefono(request.getParameter("telefono"));
        d.setCelular(request.getParameter("celular"));
        d.setEmail(request.getParameter("email"));
        //d.setFecNacimiento(new Date(request.getParameter("fecnacimiento")));
        d.setSexo(request.getParameter("sexo"));
        d.setUsuario(request.getParameter("usuario"));

        daoAdministrador.actualizar(d);

        response.sendRedirect("Usuarios/Admin_admin.jsp");

    }

    protected void borrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int idad = Integer.parseInt(request.getParameter("idAdmin"));
        Administradores d = new Administradores();
        daoAdministrador.encontrar(idad);
        daoAdministrador.borrar(d);
        String pag = "Usuarios/Admin_admin.jsp";

        //redige a la pagina listado
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void encontrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String pag = "Usuarios/Admin_admin.jsp";
        request.setAttribute("dato", daoAdministrador.encontrarTodos());
        request.getRequestDispatcher(pag).forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
