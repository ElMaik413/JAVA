public class reto5 {

    public static void main(String[] args) {
        String prueba = "Contrasena1!";
        System.out.println("¿Es válida? " + validarContraseñas(prueba));
    }

    public static boolean validarContraseñas(String password) {
        if (password == null || password.length() < 8) return false;

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneSimbolo = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            } else if (Character.isLowerCase(c)) {
                tieneMinuscula = true;
            } else if (Character.isDigit(c)) {
                tieneNumero = true;
            } else if (!Character.isWhitespace(c)) { // Evita que un espacio cuente como símbolo
                tieneSimbolo = true;
            }
        }

        return tieneMayuscula && tieneMinuscula && tieneNumero && tieneSimbolo;
    }
}