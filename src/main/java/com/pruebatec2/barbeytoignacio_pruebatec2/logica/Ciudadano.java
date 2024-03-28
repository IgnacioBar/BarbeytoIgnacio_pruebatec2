package com.pruebatec2.barbeytoignacio_pruebatec2.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author ignac
 */

@Entity
public class Ciudadano implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String dni;
    private String email;
    private String telefono;

    // Relación uno a muchos con Turnos
    @OneToMany(mappedBy = "ciudadano")
    private List<Turno> turnos;

    // Constructores, getters y setters

    public Ciudadano() {
    }

    public Ciudadano(String nombre, String dni, String email, String telefono, List<Turno> turnos) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.turnos = turnos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
    
    
}
