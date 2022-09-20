/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.AlumnoDao;
import dao.UsuarioDao;
import dao.ProfesorDao;
import dao.AdministradorDao;
import modelo.Usuario;
import modelo.Alumnos;
import modelo.Profesores;
import modelo.Administradores;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author msche
 */
@WebServlet(name = "LoginControl", urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {

    UsuarioDao daoUsuario = new UsuarioDao();
    AlumnoDao daoAlumno = new AlumnoDao();
    ProfesorDao daoProfesor = new ProfesorDao();
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
                    login(request, response);
                    break;
                case 2:
                    logout(request, response);
                    break;
            }
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            Usuario d = daoUsuario.login(request.getParameter("username"), request.getParameter("password"));
            int id = daoUsuario.idAdm_Alu_Pro(request.getParameter("username"));

            if (d == null) {
                System.out.println("No se enecontro al usuario");
                request.setAttribute("dato", "Clave o Usuario incorrecto");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {

                if (id >= 3000) {
                    Profesores profesor = daoProfesor.encontrar(id);
                    d.setProfesor(profesor);
                    System.out.println("Se encontro al usuario");
                    HttpSession ses = request.getSession(true);
                    ses.setAttribute("usuario", d);
                    String pag = "/index.html";
                    //redirige a la pagina index
                    request.getRequestDispatcher(pag).forward(request, response);
                } else if (id >= 2000) {
                    Alumnos alumno = daoAlumno.encontrar(id);
                    d.setAlumno(alumno);
                    System.out.println("Se encontro al usuario");
                    HttpSession ses = request.getSession(true);
                    ses.setAttribute("usuario", d);
                    String pag = "/index.html";
                    //redirige a la pagina index
                    request.getRequestDispatcher(pag).forward(request, response);
                } else if (id >= 1000) {
                    Administradores administrador = daoAdministrador.encontrar(id);
                    d.setAdministrador(administrador);
                    System.out.println("Se encontro al usuario");
                    HttpSession ses = request.getSession(true);
                    ses.setAttribute("usuario", d);
                    String pag = "/index.html";
                    //redirige a la pagina index
                    request.getRequestDispatcher(pag).forward(request, response);
                }
                
            }
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession ses = request.getSession();
        ses.removeAttribute("usuario");
        response.sendRedirect("Menu.jsp");
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
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
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
