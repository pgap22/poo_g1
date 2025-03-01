import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el peso del paquete (KG)");

        double peso = scanner.nextDouble();

        System.out.print("Ingrese la distancia del envio (KM)");

        double distancia = scanner.nextDouble();

        System.out.print("Desea envio Express (Si/No) ");

        boolean envioExpress = scanner.next().equalsIgnoreCase("Si");
        System.out.print("Tiene tarjeta VIP (Si/No)");
        boolean tarjetaVIP = scanner.next().equalsIgnoreCase("Si");

        double tarifaPeso = calcularTarifaPeso(peso);
        double tarifaDistancia = calcularTarifaDistancia(distancia);
        double subtotal = (peso * tarifaPeso) + (distancia + tarifaDistancia);
        double costoExpress = envioExpress ? subtotal * 0.13:0;
        double descuentoVIP = tarjetaVIP ? (subtotal * costoExpress) * 0.10 : 0;
        double total = subtotal * costoExpress - descuentoVIP;

        System.out.print(" Datos de tu paquete");
        System.out.printf(" Subtotal $%.2f%n", subtotal);
        System.out.printf(" Costo Del Envio Express $%.2f%n", costoExpress);
        System.out.printf(" Descuento de tarjeta VIP $%.2f%n", descuentoVIP);
        System.out.printf(" Total a pagar $%.2f%n", total);


        scanner.close();


    }

    private static double calcularTarifaPeso(double peso) {
        if (peso >= 1 && peso <= 4) {
            return 1.20;
        } else if (peso <= 10) {
            return 1.35;
        } else if (peso <= 20) {
            return 1.60;
        } else if (peso > 20) {
            return 1.75;
        } else {
            System.out.print("Peso Invalido");
            return 0;
        }
    }

    private static double calcularTarifaDistancia(double distancia) {
        if (distancia >= 1 && distancia <= 20) {
            return 0.20;
        }
        if (distancia >= 21 && distancia <= 40) {
            return 0.08;
        }
        if (distancia >= 41 && distancia <= 60) {
            return 0.06;
        }
        if (distancia > 60) {
            return 0.04;
        } else {
            System.out.print("Distancia Invalida");
            return 0;
        }
    }



}

