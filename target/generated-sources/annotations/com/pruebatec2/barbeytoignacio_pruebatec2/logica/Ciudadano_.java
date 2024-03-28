package com.pruebatec2.barbeytoignacio_pruebatec2.logica;

import com.pruebatec2.barbeytoignacio_pruebatec2.logica.Turno;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-26T17:05:51")
@StaticMetamodel(Ciudadano.class)
public class Ciudadano_ { 

    public static volatile ListAttribute<Ciudadano, Turno> turnos;
    public static volatile SingularAttribute<Ciudadano, Long> id;
    public static volatile SingularAttribute<Ciudadano, String> telefono;
    public static volatile SingularAttribute<Ciudadano, String> nombre;
    public static volatile SingularAttribute<Ciudadano, String> dni;
    public static volatile SingularAttribute<Ciudadano, String> email;

}