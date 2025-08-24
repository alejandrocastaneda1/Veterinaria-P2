package org.example;

import javax.swing.JOptionPane;

public class Veterinaria {
    private String nombre;
    private final Mascota[] listaMascotas;
    private double consultaBase = 50000.0;

    public Veterinaria(String nombre) {
        this.nombre = nombre;
        this.listaMascotas = new Mascota[10]; // capacidad fija
    }

    // AGREGAR mascota
    public boolean agregarMascota(String nombre, String especie, String raza, String edad,
                                  String ID, String propietario, String contacto) {
        // verificar duplicado
        for (int i = 0; i < listaMascotas.length; i++) {
            Mascota m = listaMascotas[i];
            if (m != null && m.getID().equals(ID)) {
                return false; // ID duplicado
            }
        }
        // buscar espacio libre
        for (int i = 0; i < listaMascotas.length; i++) {
            if (listaMascotas[i] == null) {
                listaMascotas[i] = new Mascota(nombre, especie, raza, edad, ID, propietario, contacto);
                return true;
            }
        }
        return false; // sin espacio
    }

    // ELIMINAR por ID
    public boolean eliminarMascota(String ID) {
        for (int i = 0; i < listaMascotas.length; i++) {
            Mascota m = listaMascotas[i];
            if (m != null && m.getID().equals(ID)) {
                listaMascotas[i] = null;
                return true;
            }
        }
        return false;
    }

    // ACTUALIZA
    public boolean actualizarMascota(String nombre, String especie, String raza, String edad, String ID) {
        for (int i = 0; i < listaMascotas.length; i++) {
            Mascota m = listaMascotas[i];
            if (m != null && m.getID().equals(ID)) {
                m.setNombre(nombre);
                m.setEspecie(especie);
                m.setRaza(raza);
                m.setEdad(edad);
                m.setID(ID);
                return true;
            }
        }
        return false;
    }

    // OBTENER
    public Mascota obtenerMascota(String ID) {
        for (int i = 0; i < listaMascotas.length; i++) {
            Mascota m = listaMascotas[i];
            if (m != null && m.getID().equals(ID)) {
                return m;
            }
        }
        return null;
    }

    // DEVUELVE arreglo completo (puede contener nulls)
    public Mascota[] obtenerListaMascota() {
        return listaMascotas;
    }

    // CALCULAR COSTO
    public double calcularCosto(Mascota mascota) {
        double costo = consultaBase;
        if (mascota == null) return costo;

        String especie = mascota.getEspecie();
        if (especie != null && (especie.equalsIgnoreCase("perro") || especie.equalsIgnoreCase("gato"))) {
            costo += consultaBase * 0.1; // +10%
        }

        String edadStr = mascota.getEdad();
        if (edadStr != null && edadStr.matches("\\d+")) { // solo si contiene dígitos
            int edad = Integer.parseInt(edadStr);
            if (edad > 10) {
                costo += consultaBase * 0.2; // +20%
            }
        } else {
            // si la edad no es numérica, mostramos aviso y no sumamos el +20%
            JOptionPane.showMessageDialog(null, "Edad inválida para la mascota con ID: " + mascota.getID());
        }

        JOptionPane.showMessageDialog(null, "El costo de la consulta para " + mascota.getNombre() + " es: $" + costo);
        return costo;
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre){
            this.nombre = nombre;
    }
    public double getConsultaBase() {
        return consultaBase;
    }
    public void setConsultaBase(double consultaBase) {
        this.consultaBase = consultaBase;
    }
}
