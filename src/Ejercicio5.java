import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Empleado {
    String nombre;
    double salario;
    String departamento;
    int horasExtras;
    double pagoHorasExtras;

    public Empleado(String nombre, double salario, String departamento, int horasExtras, double pagoHorasExtras) {
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = departamento;
        this.horasExtras = horasExtras;
        this.pagoHorasExtras = pagoHorasExtras;
    }

    public void mostrarInfo() {
        System.out.println("\n--- Datos del empleado ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario: $" + String.format("%.2f", salario));
        System.out.println("Departamento: " + departamento.substring(0, 1).toUpperCase() + departamento.substring(1));
        System.out.println("Horas extras trabajadas: " + horasExtras);
        System.out.println("Pago total de horas extras: $" + String.format("%.2f", pagoHorasExtras));
    }
}

public class PagoHorasExtras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Empleado> empleados = new ArrayList<>();

        int n = -1;
        do {
            System.out.print("Ingrese el número de empleados a procesar: ");
            String nInput = scanner.nextLine().trim();
            if (nInput.isEmpty()) {
                System.out.println("El número de empleados no puede estar vacío.");
                continue;
            }
            try {
                n = Integer.parseInt(nInput);
                if (n <= 0) {
                    System.out.println("El número de empleados debe ser mayor a 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                n = -1;
            }
        } while (n <= 0);

        for (int i = 0; i < n; i++) {
            System.out.println("\nRegistro del empleado #" + (i + 1));

            String nombre;
            do {
                System.out.print("Nombre: ");
                nombre = scanner.nextLine().trim();
                if (nombre.isEmpty()) System.out.println("El nombre no puede estar vacío.");
            } while (nombre.isEmpty());

            double salario = -1;
            do {
                System.out.print("Salario mensual: ");
                String salarioInput = scanner.nextLine().trim();
                if (salarioInput.isEmpty()) {
                    System.out.println("El salario no puede estar vacío.");
                    continue;
                }
                try {
                    salario = Double.parseDouble(salarioInput);
                    if (salario <= 0) {
                        System.out.println("El salario debe ser mayor a 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un salario válido y mayor a 0.");
                    salario = -1;
                }
            } while (salario <= 0);

            String departamento;
            do {
                System.out.print("Departamento (Gerencia, Auditoria, Tecnología, Contabilidad): ");
                departamento = scanner.nextLine().trim().toLowerCase();
                if (departamento.isEmpty()) {
                    System.out.println("El departamento no puede estar vacío.");
                }
            } while (departamento.isEmpty());

            int horasExtras = -1;
            do {
                System.out.print("Horas extras trabajadas (máximo 20): ");
                String horasInput = scanner.nextLine().trim();
                if (horasInput.isEmpty()) {
                    System.out.println("Las horas extras no pueden estar vacías.");
                    continue;
                }
                try {
                    horasExtras = Integer.parseInt(horasInput);
                    if (horasExtras < 0 || horasExtras > 20) {
                        System.out.println("Las horas extras deben estar entre 0 y 20.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido entre 0 y 20.");
                    horasExtras = -1;
                }
            } while (horasExtras < 0 || horasExtras > 20);

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

            double pagoHorasExtras = ((salario / 30) * horasExtras) + (horasExtras * bonoPorHora);

            empleados.add(new Empleado(nombre, salario, departamento, horasExtras, pagoHorasExtras));
        }

        System.out.println("\n===== RESUMEN DE EMPLEADOS =====");
        for (Empleado empleado : empleados) {
            empleado.mostrarInfo();
        }

        scanner.close();
    }
}
