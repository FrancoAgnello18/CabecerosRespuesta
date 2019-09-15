/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "CookiesServlet", urlPatterns = {"/CookiesServlet"})
public class CookiesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookiesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CookiesServlet at " + request.getContextPath() + "</h1>");
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
        //Suponemos que el usuario está visitando por primera vez nuestro sitio
        boolean nuevoUsuario = true;
        
        //Obtenemos todas las cookies
        Cookie [] cookies = request.getCookies();
        
        //Buscamos si ya existe una cookie creada con anterioridad
        //llamda visitanteRecurrente
        if(cookies != null){
            for (Cookie c : cookies){
                if(c.getName().equals("visitanteRecurrente")&& c.getValue().equals("si")){
                    //En caso de que ya existe una cookie indicando que ya existe un usuario registrado
                    //con anterioridad ponemos la bandera en falso y salimos del ciclo
                    nuevoUsuario = false;
                    break;
                }
            }//fin del for
        }//fin del if
        //Revisamos si el usuario es un nuevo visitante
        String mensaje = null;
        if(nuevoUsuario){
            //En caso de ser un usuario nuevo creamos el objeto Cookie
            Cookie visitanteCookie = new Cookie ("visitanteRecurrente", "si");
            //Agregamos la cookie en la respuesta
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio";
        }else{
            mensaje = "Gracias por visitar NUEVAMENTE nuestro sitio";
        }
        //Escribimos la salida
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //Omitimos código HTML para simplificar el código
        out.println("Mensaje: " + mensaje);
        
    }

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
