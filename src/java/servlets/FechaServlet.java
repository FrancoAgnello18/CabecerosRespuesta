/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FechaServlet", urlPatterns = {"/FechaServlet"})
public class FechaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            response.setContentType ("text/html;charset=UTF-8");
            response.setHeader("refresh", "1");//dado en segundos
            //Obtenemos la fecha actual y le aplicamos un formato
            Date fecha = new Date();
            //API para utilizar la clase SimpleDateFormat
            //http://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
            
            //SimpleDateFormat formateador = new SimpleDateFormat ("dd" 'de' MMM 'de' YYY 'a las' HH:mm:ss");
            SimpleDateFormat formateador = new SimpleDateFormat("'Hora actualizada' HH:mm:ss");
            String fechaConFormato = formateador.format(fecha);
          
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FechaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Fecha actualizada:" + fechaConFormato + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
