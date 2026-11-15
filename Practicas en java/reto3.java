import javax.swing.JOptionPane;

public class reto3 {
    public static void main(String[] args) {
        int numeroSecreto = 12, intentos = 0, intentosmax = 10;

        while (intentos < intentosmax) {
            int N = Integer.parseInt(JOptionPane.showInputDialog("Adivina el número:"));
            intentos++;

            if (N < numeroSecreto) {
                JOptionPane.showMessageDialog(null, "Te faltó, es más alto. Llevas " + intentos + " intentos.");
            } else if (N > numeroSecreto) {
                JOptionPane.showMessageDialog(null, "Te pasaste, es más bajo. Llevas " + intentos + " intentos.");
            } else {
                JOptionPane.showMessageDialog(null, "¡Correcto! Lo adivinaste en " + intentos + " intentos.");
                break;
            }
        }

        if (intentos >= intentosmax) {
            JOptionPane.showMessageDialog(null, "Se te acabaron los intentos. Suerte para la próxima, chavo.");
        }
    }
}