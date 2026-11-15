import javax.swing.JOptionPane;

public class Ejercicio29 {
    public static void main(String[] args) {
        int d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia (dd):"));
        int m = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes (mm):"));
        int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año (aaaa):"));
        String primerDiaStr = JOptionPane.showInputDialog("Ingrese el dia del 1 de enero (l, m, x, j, v, s, d):").toLowerCase();

        int diasTotales = 0;
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        boolean esBisiesto = (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
        if (esBisiesto) {
            diasMes[1] = 29;
        }

        for (int i = 0; i < m - 1; i++) {
            diasTotales += diasMes[i];
        }
        diasTotales += (d - 1);

        int offsetInicial = 0;
        switch (primerDiaStr) {
            case "l": offsetInicial = 0; break;
            case "m": offsetInicial = 1; break;
            case "x": offsetInicial = 2; break;
            case "j": offsetInicial = 3; break;
            case "v": offsetInicial = 4; break;
            case "s": offsetInicial = 5; break;
            case "d": offsetInicial = 6; break;
        }

        int indiceDia = (offsetInicial + (diasTotales % 7)) % 7;
        String[] nombresDias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sabado", "Domingo"};

        JOptionPane.showMessageDialog(null, "El dia correspondiente es: " + nombresDias[indiceDia]);
    }
}