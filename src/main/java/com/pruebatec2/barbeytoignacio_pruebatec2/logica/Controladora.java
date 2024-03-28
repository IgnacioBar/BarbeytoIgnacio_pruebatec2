package com.pruebatec2.barbeytoignacio_pruebatec2.logica;

import com.pruebatec2.barbeytoignacio_pruebatec2.persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author ignac
 */
public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    
    /* CIUDADANOS */
    public void crearCiudadano(Ciudadano ciudadano) {
        controlPersis.crearCiudadano(ciudadano);
    }    
    
    public void eliminarCiudadano(Long id) {
        controlPersis.eliminarCiudadano(id);
    }
    
    public List<Ciudadano> traerCiudadanos() {
        return controlPersis.traerCiudadano();
    }
    
    public void editarCiudadano(Ciudadano ciudadano) {
        controlPersis.editarCiudadano(ciudadano);
    }


    
    
    /* TURNOS */
    public void crearTurno(Turno turno, Long id) {
        //Obtener turno a partir del ID
        Ciudadano ciudadano = controlPersis.ObtenerCiudadano(id);
        
        //Setear los TURNOS del CIUDADANO antes de persistir
        turno.setCiudadano(ciudadano);
        
        controlPersis.crearTurno(turno);
    }    
    
    public void eliminarTurno(Long id) {
        controlPersis.eliminarTurno(id);
    }
    
    public List<Turno> traerTurnos() {
        return controlPersis.traerTurnos();
    }
    
    public void editarTurno(Turno turno) {
        controlPersis.editarTurno(turno);
    }  

}
