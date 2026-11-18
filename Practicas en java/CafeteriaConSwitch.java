import javax.swing.JOptionPane;

public class CafeteriaConSwitch {
    public static void main(String[] args) {
        int op = 0;

        // Variables acumuladoras para el Reporte de Ventas
        int totalComprasRegistradas = 0;
        double acumuladoSinDescuentos = 0.0;
        double totalDescuentosOtorgados = 0.0;
        double importeTotalRecaudado = 0.0;
        int comprasConDescuento = 0;
        double maxCompraDespuesDescuento = 0.0;
1
        do {
            // Validación para el menú principal
            String entradaOp = JOptionPane.showInputDialog(
                "===== CAFETERÍA UNIVERSITARIA =====\n" +
                "1. Registrar una compra\n" +
                "2. Consultar reporte de ventas\n" +
                "3. Salir\n" +
                "Seleccione una opción:"
            );

            if (entradaOp == null) {
                break;
            }

            try {
                op = Integer.parseInt(entradaOp.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                continue; // Vuelve al inicio del do-while
            }

            switch (op) {
                case 1: {
                    // Validar que la cantidad de productos diferentes sea mayor a 0
                    int cantProductos = 0;
                    while (true) {
                        String entradaCant = JOptionPane.showInputDialog(
                            "Ingrese la cantidad de productos diferentes que comprará:"
                        );
                        if (entradaCant == null) break; // Por si cancela
                        
                        try {
                            cantProductos = Integer.parseInt(entradaCant.trim());
                            if (cantProductos > 0) {
                                break;
                            }
                            JOptionPane.showMessageDialog(null, "Error: La cantidad debe ser mayor a 0.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: No se permiten letras ni campos vacíos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    if (cantProductos <= 0) break; // Si canceló la cantidad, regresa al menú principal

                    double subtotal = 0; // Acumulador para el subtotal de la compra

                    // Ciclo para pedir precio y unidades de cada producto con validación
                    boolean cancelarCompra = false;
                    for (int i = 0; i < cantProductos; i++) {
                        double precioUnitario = 0;
                        while (true) {
                            String entradaPrecio = JOptionPane.showInputDialog(
                                "Producto " + (i + 1) + "\nIngrese el precio:"
                            );
                            if (entradaPrecio == null) { cancelarCompra = true; break; }

                            try {
                                precioUnitario = Double.parseDouble(entradaPrecio.trim());
                                if (precioUnitario > 0) {
                                    break;
                                }
                                JOptionPane.showMessageDialog(null, "Error: El precio debe ser mayor a 0.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error: Ingrese un precio numérico válido.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        if (cancelarCompra) break;

                        int unidades = 0;
                        while (true) {
                            String entradaUnidades = JOptionPane.showInputDialog(
                                "Producto " + (i + 1) + "\nIngrese las unidades:"
                            );
                            if (entradaUnidades == null) { cancelarCompra = true; break; }

                            try {
                                unidades = Integer.parseInt(entradaUnidades.trim());
                                if (unidades > 0) {
                                    break;
                                }
                                JOptionPane.showMessageDialog(null, "Error: Las unidades deben ser mayores a 0.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error: Ingrese un número entero válido.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        if (cancelarCompra) break;

                        subtotal += (precioUnitario * unidades); // Sumamos al subtotal general
                    }

                    if (cancelarCompra) {
                        JOptionPane.showMessageDialog(null, "Compra cancelada.");
                        break;
                    }

                    // Aplicar descuento según el subtotal
                    double descuento = 0;
                    if (subtotal >= 500) {
                        descuento = 0.15;
                    } else if (subtotal >= 200) {
                        descuento = 0.10;
                    } else if (subtotal >= 100) {
                        descuento = 0.05;
                    } else {
                        descuento = 0.0;
                    }

                    double cantidadDescuento = subtotal * descuento;
                    double totalPagar = subtotal - cantidadDescuento;

                    // Actualizar estadísticas globales para el reporte
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
                        "Subtotal: $" + String.format("%.2f", subtotal) + "\n" +
                        "Descuento: " + (int)(descuento * 100) + "%\n" +
                        "Importe desc.: $" + String.format("%.2f", cantidadDescuento) + "\n" +
                        "Total a pagar: $" + String.format("%.2f", totalPagar)
                    );
                    break;
                }
                case 2: {
                    // Reporte de ventas
                    if (totalComprasRegistradas == 0) {
                        JOptionPane.showMessageDialog(null, "No existen ventas registradas.");
                    } else {
                        JOptionPane.showMessageDialog(null,
                            "===== REPORTE DE VENTAS =====\n" +
                            "Número total de compras registradas: " + totalComprasRegistradas + "\n" +
                            "Importe acumulado antes de descuentos: $" + String.format("%.2f", acumuladoSinDescuentos) + "\n" +
                            "Total de descuentos otorgados: $" + String.format("%.2f", totalDescuentosOtorgados) + "\n" +
                            "Importe total recaudado: $" + String.format("%.2f", importeTotalRecaudado) + "\n" +
                            "Número de compras que recibieron descuento: " + comprasConDescuento + "\n" +
                            "Importe de la compra más alta después del descuento: $" + String.format("%.2f", maxCompraDespuesDescuento)
                        );
                    }
                    break;
                }
                case 3:
                    JOptionPane.showMessageDialog(null, "Bye Bye");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida, seleccione una opción del 1 al 3.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (op != 3);
    }
}