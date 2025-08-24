package org.example;

public class Cliente {
    private  String nombre;
    private  String contacto;
    private  String direccion;

    // Constructor
    public Cliente(String nombre, String contacto, String direccion) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getContacto() { return contacto; }
    public String getDireccion() { return direccion; }

    // Metodo para mostar info
    public void mostrarInfo() {
        System.out.println("Dueño: " + nombre + " | Contacto: " + contacto + " | Dirección: " + direccion);
    }
}
