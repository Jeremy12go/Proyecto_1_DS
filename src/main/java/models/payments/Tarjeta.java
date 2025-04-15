package models.payments;

import java.io.Serializable;
import java.util.Date;

public class Tarjeta extends Pago implements Serializable {

    private TipoTarjeta tipo;
    private String numero;
    private String nombreTitular;
    private Date fechaExpiracion;

    @Override
    public void RealizarPago() {
        System.out.println("Pago realizado con exito!");
    }
}
