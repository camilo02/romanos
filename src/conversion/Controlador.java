/*
 */
package conversion;

/**
 *
 * @author Cristian
 */
public class Controlador {

    /**
     * @param args the command line arguments
     */
    final String numeroPrueba = "999";

    //int cantidadDigitosEntrada = numeroPrueba.length();
    //System.out.println(convertirArabigoADecimal(darFormato(numeroPrueba,cantidadDigitosEntrada)));
    public Boolean validarEntrada() {
        //TODO
        return false;
    }
    /*
     * dependiendo de la longitud se agregan tantos ceros como sea necesario
     */

    public String darFormato(String numeroEntrada, int cantidadDigitosEntrada) {
        if (cantidadDigitosEntrada == 3) {
            numeroEntrada = "0" + numeroEntrada;
        }
        if (cantidadDigitosEntrada == 2) {
            numeroEntrada = "00" + numeroEntrada;
        } else if (cantidadDigitosEntrada == 1) {
            numeroEntrada = "000" + numeroEntrada;
        }
        return numeroEntrada;
    }

    public String convertirArabigoADecimal(String numeroEntrada) {

        int[] digitosArabigos = {0, 0, 0, 0};
        String romanoSalida = "";

        for (int i = 0; i < 4; i++) {
            digitosArabigos[i] = Character.getNumericValue(numeroEntrada.charAt(i));
        }

        for (int posicion = 0; posicion < digitosArabigos.length; posicion++) {
            romanoSalida = romanoSalida + obtenerDigitoRomano(digitosArabigos[posicion], posicion);
        }

        return romanoSalida;
    }

    public String obtenerDigitoRomano(int digitoArabigo, int posicion) {

        final String[] unidadesRomanas = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        final String[] decenasRomanas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        final String[] centenasRomanas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        final String[] millaresRomanas = {"", "M", "MM", "MMM"};

        String digitoRomano = "";

        if (posicion == 0) {
            digitoRomano = millaresRomanas[digitoArabigo];
        } else if (posicion == 1) {
            digitoRomano = centenasRomanas[digitoArabigo];
        } else if (posicion == 2) {
            digitoRomano = decenasRomanas[digitoArabigo];
        } else if (posicion == 3) {
            digitoRomano = unidadesRomanas[digitoArabigo];
        }

        return digitoRomano;
    }

}
