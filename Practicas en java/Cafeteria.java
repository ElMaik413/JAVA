import javax.swing.JOptionPane;

public class Cafeteria {
    public static void main(String[] args) {
        int op;

        // Variables acumuladoras para el Reporte de Ventas (R5)
        int totalComprasRegistradas = 0;2
        double acumuladoSinDescuentos = 0.0;
        double totalDescuentosOtorgados = 0.0;
        double importeTotalRecaudado = 0.0;
        int comprasConDescuento = 0;
        double maxCompraDespuesDescuento = 0.0;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                "===== CAFETERÍA UNIVERSITARIA =====\n" +
                "1. Registrar una compra\n" +
                "2. Consultar reporte de ventas\n" +
                "3. Salir\n" +
                "Seleccione una opción:"
            ));

            switch (op) {
                case 1: {
                    // R4: Validar que la cantidad de productos diferentes sea mayor a 0
                    int cantProductos;
                    while (true) {
                        cantProductos = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese la cantidad de productos diferentes que comprará:"
                        ));
                        if (cantProductos > 0) {
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "Error: La cantidad debe ser mayor a 0.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    }

                    double subtotal = 0; // Acumulador para el subtotal de la compra

                    // Ciclo para pedir precio y unidades de cada producto con validación (R4)
                    for (int i = 0; i < cantProductos; i++) {
                        double precioUnitario;
                        while (true) {
                            precioUnitario = Double.parseDouble(JOptionPane.showInputDialog(
                                "Producto " + (i + 1) + "\nIngrese el precio:"
                            ));
                            if (precioUnitario > 0) {
                                break;
                            }
                            JOptionPane.showMessageDialog(null, "Error: El precio debe ser mayor a 0.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                        }

                        int unidades;
                        while (true) {
                            unidades = Integer.parseInt(JOptionPane.showInputDialog(
                                "Producto " + (i + 1) + "\nIngrese las unidades:"
                            ));
                            if (unidades > 0) {
                                break;
                            }
                            JOptionPane.showMessageDialog(null, "Error: Las unidades deben ser mayores a 0.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                        }

                        subtotal += (precioUnitario * unidades); // Sumamos al subtotal general
                    }

                    // Aplicar descuento según el subtotal
                    double descuento = 0;
                    if (subtotal >= 500) {
                        descuento = 0.15; // 15%
                    } else if (subtotal >= 200) {
                        descuento = 0.10; // 10%
                    } else if (subtotal >= 100) {
                        descuento = 0.05; // 5%
                    } else {
                        descuento = 0.0;  // 0%
                    }

                    double cantidadDescuento = subtotal * descuento;
                    double totalPagar = subtotal - cantidadDescuento;

                    // Actualizar estadísticas globales para el reporte (R5)
                    totalComprasRegistradas++;
                    acumuladoSinDescuentos += subtotal;
                    totalDescuentosOtorgados += cantidadDescuento;
                    importeTotalRecaudado += totalPagar;

                    if (descuento > 0) {
                        comprasConDescuento++;
                    }

                    if (totalPagar > maxCompraDespuesDescuento) {
                        maxCompraDespuesDescuento = totalPagar;
                    }

                    // Mostrar resumen de la compra actual
                    JOptionPane.showMessageDialog(null,
                        "===== RESUMEN DE COMPRA =====\n" +
                        "Subtotal: $" + subtotal + "\n" +
                        "Descuento: " + (int)(descuento * 100) + "%\n" +
                        "Importe desc.: $" + cantidadDescuento + "\n" +
                        "Total a pagar: $" + totalPagar
                    );
                    break;
                }
                case 2: {
                    // R5: Reporte de ventas
                    if (totalComprasRegistradas == 0) {
                        JOptionPane.showMessageDialog(null, "No existen ventas registradas.");
                    } else {
                        JOptionPane.showMessageDialog(null,
                            "===== REPORTE DE VENTAS =====\n" +
                            "Número total de compras registradas: " + totalComprasRegistradas + "\n" +
                            "Importe acumulado antes de descuentos: $" + acumuladoSinDescuentos + "\n" +
                            "Total de descuentos otorgados: $" + totalDescuentosOtorgados + "\n" +
                            "Importe total recaudado: $" + importeTotalRecaudado + "\n" +
                            "Número de compras que recibieron descuento: " + comprasConDescuento + "\n" +
                            "Importe de la compra más alta después del descuento: $" + maxCompraDespuesDescuento
                        );
                    }
                    break;
                }
                case 3:
                    JOptionPane.showMessageDialog(null, "Bye Bye");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (op != 3);
    }
}