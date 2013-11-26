/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ujaen.dae.gabri_raul.hoteles.cliente.controller;

import es.ujaen.dae.gabri_raul.hoteles.servicios.ServicioOperador;
//import es.ujaen.dae.gabri_raul.hoteles.servicios.ServicioOperadorService;
//import es.ujaen.dae.gabri_raul.hoteles.servicios.Operador;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raul
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

//        ServicioOperadorService operadorWS = new ServicioOperadorService();
//        ServicioOperador servicioOperador = operadorWS.getServicioOperadorPort();

        /// comprobaciones para redirigir
        if (request.getParameter("login") != null) {
            // hay que redirigir al controlador operador.
            // la añadir la contraseña
//            Operador op = servicioOperador.login(request.getParameter("cif"), null);
//
//            if (op != null) {
//                request.getSession().setAttribute("operador", op);
//                response.sendRedirect("operador/listadousuarios");
//            } else {
//                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login/index.jsp");
//                rd.forward(request, response);
//            }

        } else {

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login/index.jsp");
            rd.forward(request, response);
        }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
