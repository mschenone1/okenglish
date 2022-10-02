/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.ProfesorDao;
import dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumnos;
import modelo.Profesores;
import modelo.Usuario;

/**
 *
 * @author msche
 */
public class ProfesorControl extends HttpServlet {
    
    UsuarioDao daoUsuario = new UsuarioDao();
    ProfesorDao daoProfesor = new ProfesorDao();

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
        String pag = "jsp/Admin/Usuarios/Admin_docente.jsp";
        request.setAttribute("dato", daoProfesor.encontrarTodos());
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

        Profesores d = new Profesores();

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

        daoProfesor.insertar(d);

        response.sendRedirect("jsp/Admin/Usuarios/Admin_alumno.jsp");

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

        Profesores d = new Profesores();

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

        daoProfesor.actualizar(d);

        response.sendRedirect("jsp/Admin/Usuarios/Admin_alumno.jsp");

    }

    protected void borrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int idad = Integer.parseInt(request.getParameter("idAdmin"));
        Profesores d = new Profesores();
        daoProfesor.encontrar(idad);
        daoProfesor.borrar(d);
        String pag = "Usuarios/Admin_admin.jsp";

        //redige a la pagina listado
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void encontrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String pag = "jsp/Admin/Usuarios/Admin_alumno.jsp";
        request.setAttribute("dato", daoProfesor.encontrarTodos());
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
            Logger.getLogger(ProfesorControl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProfesorControl.class.getName()).log(Level.SEVERE, null, ex);
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
