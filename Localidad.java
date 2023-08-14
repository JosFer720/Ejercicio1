/**
 * Esta clase guarda los datos de area de asientos, como su disponibilidad y precio.
 */
public class Localidad {
    private int Numlocalidad;
    private int Precio;
    private int EspaciosDisp;
    private int BoletosVen;

    /**
     * Construye un nuevo objeto Localidad.
     *
     * @param numlocalidad El identificador del area de asientos.
     * @param precio El precio de cada boleto en el area de asientos.
     * @param espaciosDisp El numero de espacios disponibles en el area.
     */
    public Localidad(int numlocalidad, int precio, int espaciosDisp) {
        Numlocalidad = numlocalidad;
        Precio = precio;
        EspaciosDisp = espaciosDisp;
        BoletosVen = 0;
    }

    /**
     * Obtiene el identificador del area de asientos.
     *
     * @return El identificador del area de asientos.
     */
    public int getNumlocalidad() {
        return Numlocalidad;
    }

    /**
     * Obtiene el numero de boletos vendidos en el area.
     *
     * @return El numero de boletos vendidos.
     */
    public int getBoletosVen() {
        return BoletosVen;
    }

    /**
     * Obtiene el numero de espacios disponibles en el area.
     *
     * @return El numero de espacios disponibles.
     */
    public int getEspaciosDisp() {
        return EspaciosDisp;
    }

    /**
     * Obtiene el precio de cada boleto en el area.
     *
     * @return El precio de cada boleto.
     */
    public int getPrecio() {
        return Precio;
    }

    /**
     * Incrementa el numero de boletos vendidos por area.
     *
     * @param cantidad El numero de boletos que se van a vender.
     */
    public void VenderBoletos(int cantidad) {
        BoletosVen += cantidad;
    }

    /**
     * Reduce el numero de espacios disponibles en el area.
     *
     * @param cantidad El numero de espacios que se van a actualizar.
     */
    public void ActualizarEspacios(int cantidad) {
        EspaciosDisp -= cantidad;
    }
}
