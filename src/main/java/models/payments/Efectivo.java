package models.payments;

import java.io.Serializable;

public class Efectivo extends Pago implements Serializable {

    @Override
    public void RealizarPago() {
        System.out.println("Pago realizado con exito!");
    }
}
