package com.pruebatec2.barbeytoignacio_pruebatec2.servlets;

import com.pruebatec2.barbeytoignacio_pruebatec2.logica.Controladora;
import com.pruebatec2.barbeytoignacio_pruebatec2.logica.Turno;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ignac
 */
@WebServlet("/TurnoSv")
public class TurnoSv extends HttpServlet {
    Controladora controlLogica = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
        String consultaFecha = request.getParameter("fecha_filtro");
        String consultaEstado = request.getParameter("estado_filtro");

        // Se obtienen los TURNOS desde la BD
        List<Turno> listTurnos = controlLogica.traerTurnos();

        // Preparar el formato de fecha para parsear el string de fecha
        SimpleDateFormat formato = new SimpleDateFormat("yyyyy-mm-dd");

        // Filtrar los turnos utilizando streams y expresiones lambda
        List<Turno> turnosFiltrados = listTurnos.stream()
            .filter(turno -> {
                if (consultaEstado != null && !consultaEstado.isEmpty()) {
                    return turno.getEstado().equalsIgnoreCase(consultaEstado);
                } else {
                    return true;
                }
            })
            .filter(turno -> {
                if (consultaFecha != null && !consultaFecha.isEmpty()) {
                    Date fechaFiltro = null;
                    try {
                        fechaFiltro = formato.parse(consultaFecha);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return fechaFiltro != null && turno.getFecha().equals(fechaFiltro);
                } else {
                    return true;
                }
            })
            .toList();


        // Establecer los resultados en la solicitud para que se muestren en el JSP
        request.setAttribute("turnos", turnosFiltrados);

        // Redirigir de vuelta al formulario
        request.getRequestDispatcher("index.jsp").forward(request, response); 
    }

        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Obtener datos desde el JSP
        String fechaIngresada = request.getParameter("fecha_turno");
        String descripcionTramite = request.getParameter("descripcion_turno");
        String idCiudadano = request.getParameter("id_ciudadano");


        if (fechaIngresada != null && !fechaIngresada.isEmpty()) {
            try {
                //Convertir la fecha
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-mm-dd");
                Date fecha = sdf.parse(fechaIngresada);

                //Crear nuevo TURNO
                Turno turno = new Turno();
                turno.setFecha(fecha);
                turno.setDescripcionTramite(descripcionTramite);
                turno.setEstado("En Espera");

                //Mandar a persistir el partido, enviado los IDs 
                controlLogica.crearTurno(turno, Long.parseLong(idCiudadano));

                // Redirigir de vuelta al formulario
                request.getRequestDispatcher("index.jsp").forward(request, response);               

            } catch (ParseException ex) {
                Logger.getLogger(TurnoSv.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            response.getWriter().println("La fecha es requerida");
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
