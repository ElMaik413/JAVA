public class reto5 {
    public static boolean validarContraseña(String password) {
        if (password == null || password.length() < 8) return false;

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneSimbolo = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) tieneMayuscula = true;
            else if (Character.isLowerCase(c)) tieneMinuscula = true;
            else if (Character.isDigit(c)) tieneNumero = true;
            else tieneSimbolo = true;
        }

        return tieneMayuscula && tieneMinuscula && tieneNumero && tieneSimbolo;
    }
}