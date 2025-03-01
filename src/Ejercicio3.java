import javax.swing.JOptionPane;

public class Ejercicio3 {
    public static void main(String[] args) {
        // Capturar datos del cliente
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        String apellido = JOptionPane.showInputDialog("Ingrese su apellido:");

        // Selección de tipo de jet
        String[] opcionesJets = {"Light Jet", "Super Jet"};
        String tipoJet = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de jet:","Tipo de Jet", JOptionPane.QUESTION_MESSAGE, null, opcionesJets, opcionesJets[0]);

        // Precio por hora según tipo de jet
        double precioPorHora = tipoJet.equals("Light Jet") ? 3000 : 4500;

        // Capturar cantidad de horas
        int horas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de horas a alquilar:"));

        // Determinar descuento
        double descuento = 0;
        if (horas >= 4 && horas <= 8) {
            descuento = 0.15;
        } else if (horas >= 9 && horas <= 12) {
            descuento = 0.20;
        } else if (horas >= 13 && horas <= 16) {
            descuento = 0.25;
        } else if (horas >= 17) {
            descuento = 0.30;
        }

        // Calcular monto total
        double precioSinDescuento = precioPorHora * horas;
        double montoDescuento = precioSinDescuento * descuento;
        double precioFinal = precioSinDescuento - montoDescuento;

        // Mostrar información al cliente
        String mensaje = "--- Factura de Alquiler ---\n" +
                "Cliente: " + nombre + " " + apellido + "\n" +
                "Tipo de Jet: " + tipoJet + "\n" +
                "Cantidad de Horas: " + horas + "\n" +
                "Precio sin descuento: $" + precioSinDescuento + "\n" +
                "Descuento aplicado: $" + montoDescuento + "\n";

        JOptionPane.showMessageDialog(null, mensaje, "Resumen de Alquiler", JOptionPane.INFORMATION_MESSAGE);
    }
}
