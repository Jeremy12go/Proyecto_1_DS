package models.payments;

import java.util.Date;

public class Tarjeta extends Pago{

    private TipoTarjeta tipo;
    private String numero;
    private String nombreTitular;
    private Date fechaExpiracion;

    @Override
    public void RealizarPago() {
        System.out.println("Pago realizado con exito!");
    }
}
