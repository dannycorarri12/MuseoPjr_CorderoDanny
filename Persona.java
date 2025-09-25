/**
 * Modela a una persona que puede tener asignado un boleto de museo.
 * <p>
 * Clase de lógica de negocios.
 * </p>
 * @author Danny
 * @version 1.0
 * @since 2025-09-24
 */
public class Persona {
    /** Nombre de la persona. */
    private String nombre;
    /** Identificación (cédula) de la persona. */
    private String identificacion;
    /** Relación de asociación: boleto asignado a la persona (puede ser null). */
    private BoletoMuseo miBoleto;

    /**
     * Crea una persona indicando nombre e identificación.
     * @param nombre nombre de la persona
     * @param ident identificación de la persona
     */
    public Persona(String nombre, String ident) {
        this(nombre);
        identificacion = ident;
    }

    /**
     * Crea una persona indicando únicamente el nombre.
     * @param nombre nombre de la persona
     */
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Actualiza la identificación de la persona.
     * @param pIdentificacion nueva identificación
     */
    public void setIdentificacion(String pIdentificacion) {
        identificacion = pIdentificacion;
    }

    /**
     * Asigna un boleto a la persona.
     * @param pMiBoleto instancia de {@link BoletoMuseo} a asignar
     */
    public void asignarBoleto(BoletoMuseo pMiBoleto) {
        miBoleto = pMiBoleto;
    }

    /**
     * Devuelve el número del boleto asignado.
     * <b>Precondición:</b> se debe haber asignado un boleto previamente.
     * @return número de boleto
     * @throws NullPointerException si no hay boleto asignado
     */
    public int consultarMiNumeroDeBoleto() {
        return miBoleto.getNumeroBoleto();
    }

    /**
     * Representación textual de la persona, incluyendo boleto si existe.
     * @return descripción legible de la persona
     */
    public String toString() {
        String msg = "Persona\\n";
        msg += "  Nombre: " + nombre + "\\n";
        msg += "  Identificacion: " + identificacion + "\\n";
        if (miBoleto != null) {
            msg += "  Boleto asignado: #" + miBoleto.getNumeroBoleto() + "\\n";
        } else {
            msg += "  Boleto asignado: (ninguno)\\n";
        }
        return msg;
    }
}