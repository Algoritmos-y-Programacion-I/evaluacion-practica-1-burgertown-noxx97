package ui;

import java.util.Scanner;

public class BurgerTown {

    public static Scanner reader;
    public static double[] preciosPlatos;
    public static int[] cantidadPlatos;
    public static int totalPlatos;
    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

/**
     * Description: This method is responsible for starting global variables
     * pre: The scanner reader must be declared
     * pos: l Scanner reader is initialized
    */
    public static void inicializarGlobales() {

        reader = new Scanner(System.in);

    }


/**
     * Description: This method is responsible for displaying the menu to the user and showing the result messages for each functionality
     * pre: The Scanner reader must be initialized
     * pre: The price array must be initialized
    */

    public static void menu() {

        System.out.println("Welcome to BurgerTown!");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMain Menu:");
            System.out.println("1. Request prices ($) and quantities of each dish sold on the day");
            System.out.println("2. Calculate the total number of dishes sold on the day");
            System.out.println("3. Calculate the average price of the dishes sold on the day");
            System.out.println("4. Calculate total sales (money raised) during the day");
            System.out.println("5. Consult the number of dishes that have exceeded a minimum sales limit on the day");
            System.out.println("6. Exit");
            System.out.println("\nEnter the option to execute");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de platos vendidos en el dia fue de: "+calcularTotalPlatosVendidos());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de los platos vendidos en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nDigite el limite minimo de ventas a analizar");
                    double limite = reader.nextDouble();
                    System.out.println("\nDe las "+preciosPlatos.length+" referencias vendidas en el dia, "+consultarPlatosSobreLimite(limite)+" superaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    System.out.println("\nOpcion invalida, intenta nuevamente.");
                    break;
            }

        } while (!salir);

    }

/**
     * Description: This method is responsible for asking the user the number of different dishes that were 
     * sold on the day.
     */
    
     public static void establecerCantidadVendida() {
        System.out.println("\nDigite el numero de platos diferentes vendidos en el dia ");
        int platos = reader.nextInt();

        preciosPlatos = new double[platos];
        cantidadPlatos = new int[platos];
    }


    public static void solicitarDatos() {
        for (int i = 0; i < preciosPlatos.length; i++) {
            System.out.println("Ingrese el precio del plato " + (i + 1) + ":");
            preciosPlatos[i] = reader.nextDouble();
            System.out.println("Ingrese la cantidad vendida del plato " + (i + 1) + ":");
            cantidadPlatos[i] = reader.nextInt();
        }
    }

/**
     * Description: This method is responsible for calculating the total amount of the different dishes sold on the day.
     */
    public static int calcularTotalPlatosVendidos() {
        int totalPlatos = 0;
        for (int cantidad : cantidadPlatos) {
            totalPlatos += cantidad;
        }
        return totalPlatos;
    }


    public static double calcularPrecioPromedio() {
        double totalPrecio = 0;
        for (int i = 0; i < preciosPlatos.length; i++) {
            totalPrecio += preciosPlatos[i] * cantidadPlatos[i];
        }
        return totalPrecio / calcularTotalPlatosVendidos();
    }


    public static double calcularVentasTotales() {
        double totalVentas = 0;
        for (int i = 0; i < preciosPlatos.length; i++) {
            totalVentas += preciosPlatos[i] * cantidadPlatos[i];
        }
        return totalVentas;
    }

/**
     * Description: This method is responsible for consulting the number of dishes that have managed to exceed a minimum sales limit.
     */
    public static int consultarPlatosSobreLimite(double limite) {
        int contador = 0;
        for (int i=0 ; i<preciosPlatos.length; i++) {
            if (preciosPlatos[i]*cantidadPlatos[i]>limite) {
                contador++;
            }
        }
        return contador;
    }
} 
