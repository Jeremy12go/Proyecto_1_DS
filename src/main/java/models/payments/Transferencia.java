package models.payments;

import java.io.Serializable;

public class Transferencia extends Pago implements Serializable {

    @Override
    public void RealizarPago() {
        System.out.println("Pago realizado con exito!");
    }
}
