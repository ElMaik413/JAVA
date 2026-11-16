import javax.swing.JOptionPane;
import java.util.Random;

public class reto3 {
    public static void main(String[] args) {
        Random ram = new Random();
        int Nram = ram.nextInt(100) + 1; // Número aleatorio del 1 al 100
        int N;
        int intentos = 0; // Contador de intentos

        do {
            N = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número entre 1 y 100:"));
            intentos++; // Sumamos un intento cada vez que participa

            if (N > Nram) {
                JOptionPane.showMessageDialog(null, "El número secreto es menor");
            } else if (N < Nram) {
                JOptionPane.showMessageDialog(null, "El número secreto es mayor");
            } else {
                JOptionPane.showMessageDialog(null, "¡Correcto! Adivinaste en " + intentos + " intentos.");
            }

        } while (N != Nram);
    }
}