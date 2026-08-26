package lab03_encapsulamiento;

import java.util.Scanner;

import lab03_encapsulamiento.terrestres.Automovil;
import lab03_encapsulamiento.aereos.Avion;
import lab03_encapsulamiento.maritimos.Barco;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema de Transporte Multimodal ===");

        // AUTOMOVIL
        System.out.println("\n--- Registrar Automovil ---");

        System.out.print("Marca: ");
        String marcaAuto = scanner.nextLine();

        System.out.print("Modelo: ");
        String modeloAuto = scanner.nextLine();

        System.out.print("Año: ");
        int anioAuto = scanner.nextInt();

        System.out.print("Velocidad maxima: ");
        double velocidadAuto = scanner.nextDouble();

        System.out.print("Numero de puertas: ");
        int puertas = scanner.nextInt();

        System.out.print("¿Es electrico? (true/false): ");
        boolean electrico = scanner.nextBoolean();

        scanner.nextLine();

        Automovil auto = new Automovil(
                marcaAuto,
                modeloAuto,
                anioAuto,
                velocidadAuto,
                puertas,
                electrico
        );

        // AVION
        System.out.println("\n--- Registrar Avion ---");

        System.out.print("Marca: ");
        String marcaAvion = scanner.nextLine();

        System.out.print("Modelo: ");
        String modeloAvion = scanner.nextLine();

        System.out.print("Año: ");
        int anioAvion = scanner.nextInt();

        System.out.print("Velocidad maxima: ");
        double velocidadAvion = scanner.nextDouble();

        System.out.print("Numero de motores: ");
        int motores = scanner.nextInt();

        System.out.print("Altitud maxima: ");
        double altitud = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("Aerolinea: ");
        String aerolinea = scanner.nextLine();

        Avion avion = new Avion(
                marcaAvion,
                modeloAvion,
                anioAvion,
                velocidadAvion,
                motores,
                altitud,
                aerolinea
        );

        // BARCO
        System.out.println("\n--- Registrar Barco ---");

        System.out.print("Marca: ");
        String marcaBarco = scanner.nextLine();

        System.out.print("Modelo: ");
        String modeloBarco = scanner.nextLine();

        System.out.print("Año: ");
        int anioBarco = scanner.nextInt();

        System.out.print("Velocidad maxima: ");
        double velocidadBarco = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("Tipo de casco: ");
        String tipoCasco = scanner.nextLine();

        System.out.print("Tonelaje maximo: ");
        double tonelaje = scanner.nextDouble();

        System.out.print("Numero de tripulantes: ");
        int tripulantes = scanner.nextInt();

        Barco barco = new Barco(
                marcaBarco,
                modeloBarco,
                anioBarco,
                velocidadBarco,
                tipoCasco,
                tonelaje,
                tripulantes
        );

        // MOSTRAR INFORMACION
        System.out.println("\n=== Vehiculos Registrados ===");

        System.out.println("\n-- Automovil --");
        System.out.println(auto);

        System.out.println("\n-- Avion --");
        System.out.println(avion);

        System.out.println("\n-- Barco --");
        System.out.println(barco);

        // PROBAR VALIDACIONES
        System.out.println("\n=== Probando valores incorrectos ===");

        auto.setAnio(1800);
        auto.setNumPuertas(10);
        avion.setAltitudMaxima(-500);
        barco.setTonelajeMaximo(-100);

        // CORREGIR VALORES
        System.out.println("\n=== Corrigiendo valores ===");

        auto.setAnio(2025);
        auto.setNumPuertas(5);
        avion.setAltitudMaxima(13000);
        barco.setTonelajeMaximo(50);

        // MOSTRAR INFORMACION ACTUALIZADA
        System.out.println("\n-- Automovil actualizado --");
        System.out.println(auto);

        System.out.println("\n-- Avion actualizado --");
        System.out.println(avion);

        System.out.println("\n-- Barco actualizado --");
        System.out.println(barco);

        scanner.close();
    }
}