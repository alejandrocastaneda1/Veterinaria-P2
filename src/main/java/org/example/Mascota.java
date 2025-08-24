package org.example;


public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private String edad; // lo dejamos String según tu diseño
    private String id;
    private String propietario; // nombre del dueño
    private String contacto;    // contacto del dueño

    public Mascota(String nombre, String especie, String raza, String edad, String id,
                   String propietario, String contacto) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.id = id;
        this.propietario = propietario;
        this.contacto = contacto;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public String getEspecie() {
        return especie;
    }
    public String getRaza() {
        return raza;
    }
    public String getEdad() {
        return edad;
    }
    public String getID() {
        return id;
    }
    public String getPropietario() {
        return propietario;
    }
    public String getContacto() {
        return contacto;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public void setID(String id) {
        this.id = id;
    }
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
