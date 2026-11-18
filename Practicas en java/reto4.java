import javax.swing.JOptionPane;
import java.util.Random;
public class reto4 {
    public static void main(String[] args) {
        Random ram = new Random();
        int HPplayer = 100, HPcpu = 100;

        do {
            int N = Integer.parseInt(JOptionPane.showInputDialog(
                "1. ATK\n" +
                "2. +"));
            if (N == 1) {
                int atk = ram.nextInt(16) + 10;
                HPcpu -= atk;
                JOptionPane.showMessageDialog(null, "ATK + " + atk + " Vida restante del BOSS!!!" + HPcpu);
            } else if (N == 2) {
                int supp = ram.nextInt(13) + 8;
                HPplayer += supp;
                if (HPplayer > 100) { HPplayer = 100; }
                JOptionPane.showMessageDialog(null, "Se ah curado: " + supp + " Ahora su vida es de: " + HPplayer);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una opción valida");
            }
            if (HPcpu > 0 && (N == 1 || N == 2)) {
                int BOOSatk = ram.nextInt(16) + 10;
                HPplayer -= BOOSatk;
                JOptionPane.showMessageDialog(null,
                    "===TURNO DEL BOSS===\n" +
                    "TE AH ATACADO -" + BOOSatk + "HP\n" +
                    "VIDA RESTANTE DEL JUGADOR: " + + Math.max(0, HPplayer)
                );
            }
        } while (HPplayer > 0 &&  HPcpu > 0);
        if (HPcpu < 0) {
        JOptionPane.showMessageDialog(null, "=====VITORYYYYYYY=====");
        } else {
            JOptionPane.showMessageDialog(null, "DERROTA");
        }
    }
    
}
