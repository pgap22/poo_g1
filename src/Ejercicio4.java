import java.util.Scanner;

class Estudiante {
    private String nombre;
    private String apellido;
    private String tipoIngreso;
    private int edad;
    private double matricula;

    public Estudiante() {
        this.nombre = obtenerDato("nombre");
        this.apellido = obtenerDato("apellido");
        this.tipoIngreso = obtenerTipoIngreso();
        this.edad = obtenerEdad();
        calcularMatricula();
    }

    private String obtenerDato(String campo) {
        Scanner scanner = new Scanner(System.in);
        String dato = "";
        while (dato.trim().isEmpty()) {
            System.out.print("\nIngresa el " + campo + " del estudiante: ");
            dato = scanner.nextLine();
            if (dato.trim().isEmpty()) {
                System.out.println("El " + campo + " no puede estar vacío. Intenta nuevamente.");
            }
        }
        return dato;
    }

    private String obtenerTipoIngreso() {
        Scanner scanner = new Scanner(System.in);
        String tipoIngreso = "";
        while (!tipoIngreso.equals("Antiguo Ingreso") && !tipoIngreso.equals("Nuevo Ingreso")) {
            System.out.println("\nSelecciona el tipo de ingreso:");
            System.out.println("1. Antiguo Ingreso");
            System.out.println("2. Nuevo Ingreso");
            System.out.print("Ingresa 1 o 2: ");
            tipoIngreso = scanner.nextLine();
            if (tipoIngreso.equals("1")) {
                tipoIngreso = "Antiguo Ingreso";
            } else if (tipoIngreso.equals("2")) {
                tipoIngreso = "Nuevo Ingreso";
            } else {
                System.out.println("\nOpción no válida. Por favor ingresa 1 o 2.");
            }
        }
        return tipoIngreso;
    }

    private int obtenerEdad() {
        Scanner scanner = new Scanner(System.in);
        int edad = 0;
        boolean edadValida = false;
        while (!edadValida) {
            System.out.print("\nIngresa la edad del estudiante: ");
            try {
                String edadStr = scanner.nextLine();
                if (edadStr.trim().isEmpty()) {
                    System.out.println("La edad no puede estar vacía. Intenta nuevamente.");
                    continue;
                }
                edad = Integer.parseInt(edadStr);
                if (edad <= 0) {
                    System.out.println("La edad debe ser un número positivo. Intenta nuevamente.");
                } else {
                    edadValida = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: La edad debe ser un valor numérico. Intenta nuevamente.");
            }
        }
        return edad;
    }

    private void calcularMatricula() {
        if (edad > 15) {
            matricula = 100;
        } else if (edad > 10) {
            matricula = 125;
        } else if (edad > 5) {
            matricula = 150;
        } else {
            matricula = 0;
        }
    }

    public double calcularDescuento() {
        if (tipoIngreso.equals("Antiguo Ingreso")) {
            return matricula * 0.25;
        }
        return 0;
    }

    public double calcularMatriculaFinal() {
        return matricula - calcularDescuento();
    }

    public void mostrarInformacion() {
        System.out.println("\n==============================================");
        System.out.println("              Información del Estudiante      ");
        System.out.println("==============================================");
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Tipo de ingreso: " + tipoIngreso);
        System.out.println("Edad: " + edad);
        System.out.println("Valor de la matrícula: $" + matricula);
        System.out.println("Descuento obtenido: $" + calcularDescuento());
        System.out.println("Valor final de la matrícula: $" + calcularMatriculaFinal());
        System.out.println("==============================================");
    }
}

public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("     ¡Bienvenido al sistema de matriculas!    ");
        System.out.println("==============================================");

        Estudiante estudiante = new Estudiante();
        estudiante.mostrarInformacion();
    }
}
