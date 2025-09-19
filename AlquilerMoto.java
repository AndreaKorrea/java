/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.alquilermoto;

/**
 *
 * @author LabSispc13
 */
public class AlquilerMoto {

    private String marca; // Solo accesible dentro de esta clase
    private String modelo;
    private boolean alquilada;
    protected int año; // Accesible en subclases
    private static int totalMotos = 0; // Atributo estático compartido entre todas las instancias
    private String placa;
    // Constructor para inicializar una moto

    public AlquilerMoto(String marca, String modelo, int año, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.alquilada = false; // Inicialmente no está alquilada
        this.placa = placa;
    }

    public int getTotalMotos() {
        return totalMotos;
    }

    public static void setTotalMotos(int cantidad) {
        AlquilerMoto.totalMotos = totalMotos;
    }

    // Método estático (se puede llamar sin crear objeto)
    public static void mostrarMotosDisponibles() {
        System.out.println("Motos disponibles para alquilar: " + totalMotos);
    }
    // Método de instancia (requiere objeto para ser llamado)

    public void alquilarMoto() {
        if (!alquilada && totalMotos > 0) {
            alquilada = true;
            totalMotos--; // Reduce la cantidad de motos disponibles
            System.out.println("Moto " + marca + " " + modelo + " " + placa + " alquilada con éxito.");
        } else {
            System.out.println("No se puede alquilar esta moto.");
        }
    } // Método de instancia para devolver la moto

    public void devolverMoto() {
        if (alquilada) {
            alquilada = false;
            totalMotos++; // Incrementa la cantidad de motos disponibles
            System.out.println("Moto " + marca + " " + modelo + " " + placa + " devuelta correctamente.");
        } else {
            System.out.println("Esta moto " + placa + "no estaba alquilada.");
        }
    }
    // Método privado (solo accesible dentro de la clase)

    private void mantenimiento() {
        System.out.println("Realizando mantenimiento a la moto " + marca + " " + modelo + " " + placa);
    }
    // Método público para acceder al método privado

    public void solicitarMantenimiento() {
        System.out.println("Mantenimiento solicitado para " + marca + " " + modelo + " " + placa);
        mantenimiento();
    } // Llamada al método privado dentro de la clase
}
