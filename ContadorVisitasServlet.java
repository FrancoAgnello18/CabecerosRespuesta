package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ContadorVisitasServlet", urlPatterns = {"/ContadorVisitasServlet"})
public class ContadorVisitasServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContadorVisitasServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContadorVisitasServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Declaramos la varible contador
        int contador = 0;

        //Si existe, obtenemos el contador de visitas actual
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
        
            for (Cookie c : cookies) {
                if (c.getName().equals("contadorVisitas")) {
                    try {
                        //Obtenemos el valor del contador de visitas actual
                        contador = Integer.parseInt(c.getValue());
                    } catch (NumberFormatException e) {
                        //En caso de error, reiniciamos el contador de visitas
                        contador = 0;

                    }
                }
            }//fin del for
        }//fin del if
        
        //incrementamos el contador de visitas
        // y lo agregamos la cookie en la respuesta
        contador++;
        Cookie c = new Cookie ("contadorVisitas", Integer.toString(contador));
        //La cookie se almacenará en el cliente por 1 hora (3600 seg)
        c.setMaxAge(3600);
        response.addCookie(c);
        
        //Mandamos el mensaje al navegador
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Contador de visitas de cada cliente: " + contador);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
