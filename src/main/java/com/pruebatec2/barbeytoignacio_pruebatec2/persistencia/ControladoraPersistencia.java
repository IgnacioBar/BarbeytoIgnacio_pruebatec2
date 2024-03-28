package com.pruebatec2.barbeytoignacio_pruebatec2.persistencia;

import com.pruebatec2.barbeytoignacio_pruebatec2.logica.Ciudadano;
import com.pruebatec2.barbeytoignacio_pruebatec2.logica.Turno;
import com.pruebatec2.barbeytoignacio_pruebatec2.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignac
 */
public class ControladoraPersistencia {
    
    CiudadanoJpaController ciudadanoJPA = new CiudadanoJpaController();
    TurnoJpaController turnoJPA = new TurnoJpaController();
    
    /*PARA CIUDADANO*/
    public void crearCiudadano(Ciudadano ciudadano) {
        ciudadanoJPA.create(ciudadano);
    }

    public void eliminarCiudadano(Long id) {
        try {
            ciudadanoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Ciudadano> traerCiudadano() {
        return ciudadanoJPA.findCiudadanoEntities();
    }

    public void editarCiudadano(Ciudadano ciudadano) {
        try {
            ciudadanoJPA.edit(ciudadano);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Ciudadano ObtenerCiudadano(Long id) {
        return ciudadanoJPA.findCiudadano(id);
    }

    /*PARA TURNO*/
    public void crearTurno(Turno turno) {
        turnoJPA.create(turno);
    }

    public void eliminarTurno(Long id) {
        try {
            turnoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Turno> traerTurnos() {
        return turnoJPA.findTurnoEntities();    
    }

    public void editarTurno(Turno turno) {
        try {
            turnoJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

}
