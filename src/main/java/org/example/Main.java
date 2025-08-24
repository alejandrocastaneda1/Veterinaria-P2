package org.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Veterinaria v = new Veterinaria("Amigos Peludos");
        int opcion = 0;

        while (opcion != 6) {
            String menu ="""
                    --- MENÚ VETERINARIA ---
                    1. Agregar mascota
                    2. Eliminar mascota
                    3. Actualizar mascota
                    4. Mostrar todas las mascotas
                    5. Calcular costo consulta
                    6. Salir
                    """;

            String entrada = JOptionPane.showInputDialog(menu);
            if (entrada == null) break; // usuario canceló
            opcion = Integer.parseInt(entrada);

            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Nombre de la mascota:");
                    String especie = JOptionPane.showInputDialog("Especie:");
                    String raza = JOptionPane.showInputDialog("Raza:");
                    String edad = JOptionPane.showInputDialog("Edad:");
                    String id = JOptionPane.showInputDialog("ID:");
                    String propietario = JOptionPane.showInputDialog("Nombre del propietario:");
                    String contacto = JOptionPane.showInputDialog("Contacto del propietario:");

                    boolean agregado = v.agregarMascota(nombre, especie, raza, edad, id, propietario, contacto);
                    JOptionPane.showMessageDialog(null,
                            agregado ? "Mascota agregada con éxito." : "No se pudo agregar la mascota (ID duplicado o lleno).");
                    break;

                case 2:
                    String idEliminar = JOptionPane.showInputDialog("ID de la mascota a eliminar:");
                    boolean eliminado = v.eliminarMascota(idEliminar);
                    JOptionPane.showMessageDialog(null, eliminado ? "Mascota eliminada." : "No se encontró mascota con ese ID.");
                    break;

                case 3:
                    String idActualizar = JOptionPane.showInputDialog("ID de la mascota a actualizar:");
                    String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
                    String nuevaEspecie = JOptionPane.showInputDialog("Nueva especie:");
                    String nuevaRaza = JOptionPane.showInputDialog("Nueva raza:");
                    String nuevaEdad = JOptionPane.showInputDialog("Nueva edad:");
                    boolean actualizado = v.actualizarMascota(nuevoNombre, nuevaEspecie, nuevaRaza, nuevaEdad, idActualizar);
                    JOptionPane.showMessageDialog(null, actualizado ? "Mascota actualizada." : "No se encontró mascota con ese ID.");
                    break;

                case 4:
                    Mascota[] lista = v.obtenerListaMascota();
                    StringBuilder sb = new StringBuilder("--- Lista de Mascotas ---\n");
                    for (Mascota m : lista) {
                        if (m != null) {
                            sb.append("ID: ").append(m.getID())
                                    .append(" | Nombre: ").append(m.getNombre())
                                    .append(" | Especie: ").append(m.getEspecie())
                                    .append(" | Raza: ").append(m.getRaza())
                                    .append(" | Edad: ").append(m.getEdad())
                                    .append(" | Propietario: ").append(m.getPropietario())
                                    .append(" | Contacto: ").append(m.getContacto())
                                    .append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                    break;

                case 5:
                    String idCosto = JOptionPane.showInputDialog("ID de la mascota para calcular costo:");
                    Mascota mascota = v.obtenerMascota(idCosto);
                    if (mascota != null) {
                        v.calcularCosto(mascota); // ya muestra el JOptionPane con el costo
                    } else {
                        JOptionPane.showMessageDialog(null, "Mascota no encontrada.");
                    }
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }
}
