import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa un boleto de museo emitido en una fecha con un precio y número consecutivo.
 * <p>
 * Clase de lógica de negocios.
 * </p>
 * @author Danny
 * @version 1.0
 * @since 2025-09-24
 */
public class BoletoMuseo {
    /** Precio del boleto en colones. */
    private double precio;
    /** Número consecutivo único del boleto (contador global). */
    private int numeroBoleto;
    /** Fecha de emisión del boleto en formato yyyy-MM-dd. */
    private String fechaEmision;
    /** Contador global de boletos creados. */
    private static int contador = 0;

    /**
     * Crea un boleto con el precio indicado. Asigna número consecutivo
     * y establece la fecha de emisión al día actual.
     * @param precio precio del boleto en colones
     */
    public BoletoMuseo(double precio) {
        this.precio = precio;
        contador++;
        this.numeroBoleto = contador;
        this.fechaEmision = establecerFechaEmisionBoleto();
    }

    /**
     * Define la fecha de emisión en formato yyyy-MM-dd usando la fecha del sistema.
     * @return cadena con la fecha de emisión
     */
    private String establecerFechaEmisionBoleto() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.now().format(f);
    }

    /**
     * Devuelve el contador global de boletos creados.
     * @return cantidad de boletos creados
     */
    public static int getContador() {
        return contador;
    }

    /**
     * Obtiene el número consecutivo del boleto.
     * @return número del boleto
     */
    public int getNumeroBoleto() {
        return numeroBoleto;
    }

    /**
     * Obtiene el precio del boleto.
     * @return precio en colones
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Representación textual del boleto, incluyendo número, precio y fecha.
     * @return descripción legible del boleto
     */
    public String toString() {
        String msg = "BoletoMuseo\\n";
        msg += "  Numero: " + numeroBoleto + "\\n";
        msg += "  Precio: " + precio + "\\n";
        msg += "  Fecha Emision: " + fechaEmision;
        return msg;
    }
}