package models.payments;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Tarjeta extends Pago implements Serializable {

    private TipoTarjeta tipo;
    private String numero;
    private String nombreTitular;
    private Date fechaExpiracion;

    public Tarjeta(int monto, String tipo, String numero, String titular, LocalDate of) {
    }

    @Override
    public void RealizarPago() {
        System.out.println("Pagando $" + monto + " con tarjeta " + tipo + " a nombre de " + nombreTitular);
        System.out.println("Pago realizado con exito!");
    }
}
