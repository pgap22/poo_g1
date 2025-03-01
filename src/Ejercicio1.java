import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //obtención de los valores necesarios
        System.out.println("Ingrese el tipo de vehículo (Sedan, Pickups, Microbuses, Motos):");
        String tipoVehiculo = scanner.nextLine().trim();

        System.out.println("Ingrese la marca del vehículo:");
        String marca = scanner.nextLine().trim();

        System.out.println("Ingrese el año de fabricación del vehículo:");
        int anioFabricacion = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el país de origen (China o Estados Unidos):");
        String paisOrigen = scanner.nextLine().trim();

        //tomamos el 2025 como año actual como lo indica la guía
        int anioActual = 2025;
        int antiguedad = anioActual - anioFabricacion;

        if (antiguedad > 15) {
            System.out.println("No se aceptan vehículos con más de 15 años de fabricación.");
            return;
        }

        //cálculo de impuesto
        double porcentajeImpuesto;
        if (antiguedad >= 10) {
            porcentajeImpuesto = 0.16;
        } else if (antiguedad >= 5) {
            porcentajeImpuesto = 0.13;
        } else {
            porcentajeImpuesto = 0.11;
        }

        //validación
        double flete = obtenerCostoFlete(paisOrigen, tipoVehiculo);
        if (flete == -1) {
            System.out.println("Tipo de vehículo o país de origen no válido.");
            return;
        }

        //determinar la matricula
        double matriculaInicial;
        if (anioFabricacion >= 2020) {
            matriculaInicial = 11.99;
        } else if (anioFabricacion >= 2016) {
            matriculaInicial = 13.99;
        } else {
            matriculaInicial = 15.99;
        }

        double impuesto = porcentajeImpuesto * flete;

        double totalImportacion = impuesto + flete + matriculaInicial;

        System.out.println("\nResumen de Importación:");
        System.out.println("Tipo de vehículo: " + tipoVehiculo);
        System.out.println("Marca: " + marca);
        System.out.println("Año de fabricación: " + anioFabricacion);
        System.out.println("País de origen: " + paisOrigen);
        System.out.println("Porcentaje de impuesto: " + (porcentajeImpuesto * 100) + "%");
        System.out.printf("Costo de impuesto: $%.2f%n", impuesto);
        System.out.printf("Costo del flete marítimo: $%.2f%n", flete);
        System.out.printf("Matrícula inicial: $%.2f%n", matriculaInicial);
        System.out.printf("Total de importación: $%.2f%n", totalImportacion);
    }

    // Método para obtener el costo del flete según el país y tipo de vehículo
    public static double obtenerCostoFlete(String pais, String tipo) {
        double[][] costos = {
                {1700, 1900, 2400, 1300}, // China
                {1200, 1500, 1700, 900}   // Estados Unidos
        };

        String[] tiposVehiculo = {"Sedan", "Pickups", "Microbuses", "Motos"};
        String[] paises = {"China", "Estados Unidos"};

        int indicePais = (pais.equalsIgnoreCase("China")) ? 0 : (pais.equalsIgnoreCase("Estados Unidos") ? 1 : -1);
        int indiceTipo = -1;

        for (int i = 0; i < tiposVehiculo.length; i++) {
            if (tipo.equalsIgnoreCase(tiposVehiculo[i])) {
                indiceTipo = i;
                break;
            }
        }

        if (indicePais == -1 || indiceTipo == -1) {
            return -1; // Datos inválidos
        }

        return costos[indicePais][indiceTipo];
    }
}
