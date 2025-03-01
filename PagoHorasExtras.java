import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase que representa a un empleado
class Empleado {
    String nombre;
    double salario;
    String departamento;
    int horasExtras;
    double pagoHorasExtras;

    // Constructor para inicializar los datos del empleado
    public Empleado(String nombre, double salario, String departamento, int horasExtras, double pagoHorasExtras) {
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = departamento;
        this.horasExtras = horasExtras;
        this.pagoHorasExtras = pagoHorasExtras;
    }

    // Metodo para mostrar la información del empleado
    public void mostrarInfo() {
        System.out.println("\n--- Datos del empleado ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario: $" + String.format("%.2f", salario));
        System.out.println("Departamento: " + departamento.substring(0, 1).toUpperCase() + departamento.substring(1));
        System.out.println("Horas extras trabajadas: " + horasExtras);
        System.out.println("Pago total de horas extras: $" + String.format("%.2f", pagoHorasExtras));
    }
}

// Clase principal
public class PagoHorasExtras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Empleado> empleados = new ArrayList<>();

        // Solicitar el número de empleados a registrar
        System.out.print("Ingrese el número de empleados a procesar: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        // Bucle para registrar a cada empleado
        for (int i = 0; i < n; i++) {
            System.out.println("\nRegistro del empleado #" + (i + 1));

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Salario mensual: ");
            double salario = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Departamento (Gerencia, Auditoria, Tecnología, Contabilidad): ");
            String departamento = scanner.nextLine().toLowerCase();

            System.out.print("Horas extras trabajadas (máximo 20): ");
            int horasExtras = scanner.nextInt();
            scanner.nextLine();

            // Validar que las horas extras no excedan 20
            if (horasExtras > 20) {
                System.out.println("No puede registrar más de 20 horas extras. Se ajustará a 20.");
                horasExtras = 20;
            }

            // Asignar bono por hora según el departamento
            double bonoPorHora = switch (departamento) {
                case "gerencia" -> 3.50;
                case "auditoria" -> 1.75;
                case "tecnología" -> 2.25;
                case "contabilidad" -> 2.00;
                default -> {
                    System.out.println("Departamento no válido. Se asignará bono de 0.");
                    yield 0.0;
                }
            };

            // Calcular el pago total por horas extras
            double pagoHorasExtras = ((salario / 30) * horasExtras) + (horasExtras * bonoPorHora);

            // Crear un objeto Empleado y agregarlo a la lista
            empleados.add(new Empleado(nombre, salario, departamento, horasExtras, pagoHorasExtras));
        }

        // Mostrar el resumen de todos los empleados registrados
        System.out.println("\n===== RESUMEN DE EMPLEADOS =====");
        for (Empleado empleado : empleados) {
            empleado.mostrarInfo();
        }

        scanner.close();
    }
}