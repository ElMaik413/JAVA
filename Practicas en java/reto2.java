import javax.swing.JOptionPane;

public class reto2 {
    public static void main(String[] args) {
        int Mult = 0;
        int N = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número N para mostrar la multiplicacion hasta x10: "));
        if (N <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un número mayor a 0");
            return;
        }
        String resultado = "";
        for (int i = 1; i <= 10; i++) {
            Mult = N * i;
            resultado += N + " x " + i + " = " + Mult + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
    
}
