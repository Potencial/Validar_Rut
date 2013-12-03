package cl.cuadrasoft.utilidades;

/**
 *
 * @author Pedro G. Cuadra
 * @version 1.0-SNAPSHOT
 * @see <a href="http://github.com/Potencial/Validar_Rut">http://github.com/Potencial/Validar_Rut</a>
 */
public final class Validar {

    /**
     *
     * @param rut | Rol único tributario o Rol único nacional
     * @return True Si el Rut es válido | False si el Rut es inválido
     */
    public static boolean rut(String rut) {
        rut = escaparCaracteres(rut);
        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
        char dv = rut.charAt(rut.length() - 1);

        return modulo11(rutAux, dv);
    }

    /**
     *
     * @param rut | Rol único tributario o Rol único nacional
     * @param dv | Dígito Verificador
     * @return True Si el Rut es válido | False si el Rut es inválido
     */
    public static boolean rut(String rut, char dv) {
        rut = escaparCaracteres(rut);
        int rutAux = Integer.parseInt(rut);

        return modulo11(rutAux, dv);
    }

    private static String escaparCaracteres(String string) {
        string = string.toUpperCase();
        string = string.replace(".", "");
        string = string.replace("-", "");
        return string;
    }

    private static Boolean modulo11(int rut, char dv) {
        boolean validacion = false;
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        if (dv == (s != 0 ? s + 47 : 75)) {
            validacion = true;
        }
        return validacion;
    }

    private Validar() {
    }
}
