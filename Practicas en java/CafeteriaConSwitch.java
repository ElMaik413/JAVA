import javax.swing.JOptionPane;
public class CafeteriaConSwitch {
    public static void main(String[] args) {
        int op;
        op = Integer.parseInt(JOptionPane.showInputDialog(
        "===== CAFETERÍA UNIVERSITARIA =====\n" +
        "1. Registrar una compra\n" +
        "2. Consultar reporte de ventas\n" +
        "3. Salir\n" +
        "Seleccione una opción:"));
        switch(op) {
            case 1: int cantProductos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de productos diferentes que comprará:"));

            double subtotal = 0; // Acumulador para el subtotal de la compra

                // 2. Ciclo for para pedir precio y unidades de cada producto
                for (int i = 0; i < cantProductos; i++) {
                    double precioUnitario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto " + (i + 1) + ":"));
                    int unidades = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las unidades del producto " + (i + 1) + ":"));
                    
                    subtotal += (precioUnitario * unidades); // Sumamos al subtotal general
                }


                // 3 y 4. Aplicar descuento según el subtotal
                double descuento = 0;
                if (subtotal >= 500) {
                    descuento = 0.15; // 15% (según la tabla del problema)
                } else if (subtotal >= 200) {
                    descuento = 0.10; // 10%
                } else if (subtotal >= 100) {
                    descuento = 0.05; // 5%
                } else {
                    descuento = 0.0;  // 0%
                }

                double cantidadDescuento = subtotal * descuento;
                double totalPagar = subtotal - cantidadDescuento;

                // 5. Mostrar importe del descuento y total a pagar
                JOptionPane.showMessageDialog(null, 
                    "Subtotal: $" + subtotal + "\n" +
                    "Descuento aplicado: $" + cantidadDescuento + "\n" +
                    "El total que deberá pagar es de: $" + totalPagar);
            break;
            case 2: JOptionPane.showMessageDialog(null, "Función de reporte de ventas (Pendiente de implementar).");
                    break;
            case 3: JOptionPane.showMessageDialog(null, "Bye Bye");
            default: JOptionPane.showMessageDialog(null, "Opción inválida");
        }
    }
}
