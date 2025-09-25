import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa la venta de boletos realizada en un día específico.
 * Mantiene una relación de agregación con los boletos vendidos.
 * <p>
 * Clase de lógica de negocios.
 * </p>
 * @author Danny
 * @version 1.0
 * @since 2025-09-24
 */
public class VentaDelDia {
    /** Fecha de la venta en formato yyyy-MM-dd. */
    private String fechaDeLaVenta;
    /** Colección de boletos vendidos (agregación). */
    private List<BoletoMuseo> boletosVendidos;

    /**
     * Crea una venta para la fecha actual e inicializa la lista de boletos.
     */
    public VentaDelDia() {
        fechaDeLaVenta = establecerFechaDeLaVenta();
        boletosVendidos = new ArrayList<>();
    }

    /**
     * Registra (agrega) un boleto vendido en este día.
     * @param boleto boleto a registrar
     */
    public void registrarVentaBoleto(BoletoMuseo boleto) {
        boletosVendidos.add(boleto);
    }

    /**
     * Calcula el total de la venta del día sumando los precios de los boletos.
     * @return total acumulado en colones
     */
    public double calcularTotalVentaDelDia() {
        double total = 0.0;
        for (BoletoMuseo b : boletosVendidos) {
            total += b.getPrecio();
        }
        return total;
    }

    /**
     * Establece la fecha de la venta al día actual en formato yyyy-MM-dd.
     * @return cadena con la fecha de la venta
     */
    private String establecerFechaDeLaVenta() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.now().format(f);
    }

    /**
     * Representación textual de la venta del día con detalle de boletos y total.
     * @return descripción legible de la venta
     */
    public String toString() {
        String msg = "VentaDelDia\\n";
        msg += "  Fecha: " + fechaDeLaVenta + "\\n";
        msg += "  Cantidad de boletos: " + boletosVendidos.size() + "\\n";
        msg += "  Detalle:\\n";
        for (BoletoMuseo b : boletosVendidos) {
            msg += "    - Boleto #" + b.getNumeroBoleto() + " | " + b.getPrecio() + "\\n";
        }
        msg += "  Total: " + calcularTotalVentaDelDia();
        return msg;
    }
}