/*
 */
package conversion;

/**
 *
 * @author Cristian
 */
public class Controlador {

    private String numeroArabigoEntrada;
    private final int cantidadDigitosEntrada;
    private String numeroRomanoSalida;

    final String[] unidadesRomanas = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    final String[] decenasRomanas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    final String[] centenasRomanas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    final String[] millaresRomanas = {"", "M", "MM", "MMM"};

    public Controlador(String numeroEntrada) {
        this.numeroArabigoEntrada = numeroEntrada;
        this.cantidadDigitosEntrada = numeroEntrada.length();
        this.numeroRomanoSalida = "";
    }

    public boolean validarEntradaNumerica() {
        try {
            Integer.parseInt(numeroArabigoEntrada);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }
    
    public boolean validarRango(){
        return Integer.parseInt(numeroArabigoEntrada) > 0 && Integer.parseInt(numeroArabigoEntrada) < 4000;                               
    }

    /*
     * dependiendo de la longitud se agregan tantos ceros como sea necesario
     */
    public void darFormato() {
        if (cantidadDigitosEntrada == 3) {
            this.numeroArabigoEntrada = "0" + numeroArabigoEntrada;
        } else if (cantidadDigitosEntrada == 2) {
            this.numeroArabigoEntrada = "00" + numeroArabigoEntrada;
        } else if (cantidadDigitosEntrada == 1) {
            this.numeroArabigoEntrada = "000" + numeroArabigoEntrada;
        }

    }

    public void convertirArabigoARomano() {

        int[] digitosArabigos = {0, 0, 0, 0};

        for (int i = 0; i < 4; i++) {
            digitosArabigos[i] = Character.getNumericValue(numeroArabigoEntrada.charAt(i));
        }

        for (int posicion = 0; posicion < digitosArabigos.length; posicion++) {
            setNumeroRomanoSalida(getNumeroRomanoSalida() + obtenerDigitoRomano(digitosArabigos[posicion], posicion));
        }

    }

    public String obtenerDigitoRomano(int digitoArabigo, int posicion) {

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

    /**
     * @return the numeroRomanoSalida
     */
    public String getNumeroRomanoSalida() {
        return numeroRomanoSalida;
    }

    /**
     * @param numeroRomanoSalida the numeroRomanoSalida to set
     */
    public void setNumeroRomanoSalida(String numeroRomanoSalida) {
        this.numeroRomanoSalida = numeroRomanoSalida;
    }

}
