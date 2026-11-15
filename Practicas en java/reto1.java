import javax.swing.JOptionPane;

public class reto1 {
    public static void main(String[] args) {
        double saldo = 2000;
        int N;
        do {
        N = Integer.parseInt(JOptionPane.showInputDialog(       "1. Consultar saldo \n" +
                                                                "2. Retirar dinero \n" +
                                                                "3. Depositar dinero \n" +
                                                                "4. Salir del programa \n"
            ));
            if (N == 2) {
                int retiro = Integer.parseInt(JOptionPane.showInputDialog(  "Ingrese la cantidad a retirar. \n" +
                                                                            "Su saldo es de $" + saldo
                ));
                if (retiro > saldo) {
                    JOptionPane.showMessageDialog(null, "No le alcanza chavo");
                    return ;
                }else if (retiro <= 0){
                    JOptionPane.showConfirmDialog(null, "No puede retirar 0 o menos dinero ");
                    return ;
                }
                saldo -= retiro;
                JOptionPane.showMessageDialog(null, "Retiro de: $" + retiro + " realizado con exito :)");
            } else if (N == 3) {
                int deposito = Integer.parseInt("Ingrese la cantidad del deposito.");
                if (deposito < 0) {
                    JOptionPane.showConfirmDialog(null, "No se puede depositar menos de $1");
                    return ;
                }
                saldo += deposito;
            } else if (N == 1) {
                JOptionPane.showMessageDialog(null, "Su saldo es de: $ " + saldo);
            }
        } while (N != 4);
    }
}
