package com.local.agenda;

import java.io.Serializable;

/**
 * Created by user on 28/02/2018.
 */

// Implementamos el uso de la interfaz Seriable
    // para enviar los datos en forma de bytes....
public class Contacto implements Serializable {

    private String nombre;
    private String email;
    int edad;

    public Contacto(String nombre, String email, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
