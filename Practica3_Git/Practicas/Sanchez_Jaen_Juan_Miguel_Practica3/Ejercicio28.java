import javax.swing.JOptionPane;

public class Ejercicio28 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Introduce el entero N:");
        
        if (input != null) {
            try {
                int n = Integer.parseInt(input.trim());
                long suma = 0;
                
                while (n > 0) {
                    suma += n;
                    n /= 2;
                }
                
                JOptionPane.showMessageDialog(null, "El valor de la suma es: " + suma);
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}