package com.pruebatec2.barbeytoignacio_pruebatec2.servlets;

import com.pruebatec2.barbeytoignacio_pruebatec2.logica.Ciudadano;
import com.pruebatec2.barbeytoignacio_pruebatec2.logica.Controladora;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ignac
 */

@WebServlet(name = "CiudadanoSv", urlPatterns = {"/CiudadanoSv"})
public class CiudadanoSv extends HttpServlet {
    Controladora controlLogica = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Se obtienen los ciudadanos desde la BD
        List<Ciudadano> listCiudadanos = controlLogica.traerCiudadanos();
        
        // Establecer los resultados en la solicitud para que se muestren en el JSP
        request.setAttribute("ciudadanos", listCiudadanos);
        
        // Redirigir de vuelta al formulario
        request.getRequestDispatcher("index.jsp").forward(request, response);        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Tomo datos del JSP
        String nombre = request.getParameter("nombre_ciudadano");
        String dni = request.getParameter("dni_ciudadano");
        String email = request.getParameter("email_ciudadano");
        String telefono = request.getParameter("telefono_ciudadano");

        // Validar que el nombre solo contenga letras
        if (!nombre.matches("[a-zA-Z]+")) {
            String errorMessage = "El nombre debe contener solo letras.";
            String script = "alert('" + errorMessage + "'); window.history.back();";
            response.getWriter().println("<script>" + script + "</script>");
            return;
        }

        // Validar que el teléfono solo contenga números
        if (!telefono.matches("[0-9]+")) {
            String errorMessage = "El teléfono debe contener solo números.";
            String script = "alert('" + errorMessage + "'); window.history.back();";
            response.getWriter().println("<script>" + script + "</script>");
            return;
        }

        //Crea un nuevo objeto Ciudadano
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setNombre(nombre);
        ciudadano.setDni(dni);
        ciudadano.setEmail(email);
        ciudadano.setTelefono(telefono);

        //Se persiste el ciudadano en la BD
        controlLogica.crearCiudadano(ciudadano);

        response.sendRedirect("index.jsp");  
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