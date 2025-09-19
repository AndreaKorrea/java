/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alquilermoto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidad = 0;

        while (true) {
            try {
                System.out.print("Cantidad de motos total par inciar: ");
                cantidad = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Error, debe ser un numero entero");
            }
        }

        AlquilerMoto.setTotalMotos(cantidad);

        AlquilerMoto[] moto = new AlquilerMoto[cantidad];
        for (int i = 0; i <= moto.length; i++) {
            System.out.println("Ingresa la marca de la moto " + (i + 1) + ":");

            String marca = " ";
            while (true) {
                System.out.print("Marcas:");
                marca = sc.nextLine();
                if (!marca.isEmpty() && marca.matches("[a-zA-Z0-9-]+")) {
                    break;
                } else {
                    System.out.println("La marca solo debe contener letras y numeros");
                }
            }

            String modelo = " ";
            while (true) {
                System.out.print("Marcas:");
                modelo = sc.nextLine();
                if (!modelo.isEmpty() && modelo.matches("[a-zA-Z0-9-]+")) {
                    break;
                } else {
                    System.out.println("La modelo solo debe contener letras y numeros");
                }
            }

            int año = 0;
            while (true) {
                try {
                    System.out.print("Año: ");
                    año = Integer.parseInt(sc.nextLine());
                    if (año > 1900 && año <= 2025) {
                        break;
                    } else {
                        System.out.println("El año debe estar entre 1900 y 2025");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Error, debe ser un numero entero");
                }
            }
            
            String placa = " ";
            while (true) {
                System.out.print("Placa:");
                placa = sc.nextLine();
                if (!marca.isEmpty() && marca.matches("[A-Z]{3}-[0-9]{3}")) {
                    break;
                } else {
                    System.out.println("Placa invalida. Formato esperado: ABC-123");
                }
            }
            moto[i]= new AlquilerMoto(marca, modelo, año, placa);
            // Método estático: NO necesita crear un objeto
            AlquilerMoto.mostrarMotosDisponibles();
        System.out.println("\n--- Motos registradas---");
            for(int i=0; i<moto.length; i++){
                System.out.println("Moto"+ (i+1)+ ":"+moto[i]+ "Alquilada:"+ moto[i].getAlquilada());
            }
            // Creación de objetos (para acceder a métodos de instancia)
            //AlquilerMoto moto1 = new AlquilerMoto("Yamaha", "MT-07", 2022, "AVG233");
            //AlquilerMoto moto2 = new AlquilerMoto("Honda", "CB500X", 2021, "MAR757");
            // Métodos de instancia (requieren objeto)
            //moto1.alquilarMoto(); // Se alquila la moto Yamaha
            //oto2.alquilarMoto(); // Se alquila la moto Honda
            // Verificando disponibilidad nuevamente
            AlquilerMoto.mostrarMotosDisponibles();
            // Método de instancia para devolver una moto
            //moto1.devolverMoto();
            // Método público que llama a un método privado dentro de la clase
            //moto2.solicitarMantenimiento();
// Verificando disponibilidad después de devolver una moto
            AlquilerMoto.mostrarMotosDisponibles();
        }
    }
}

