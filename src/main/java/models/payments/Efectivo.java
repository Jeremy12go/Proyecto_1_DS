package models.payments;

import java.io.Serializable;

public class Efectivo extends Pago implements Serializable {

     public Efectivo(int monto) {
     }

     @Override
    public void RealizarPago() {
        System.out.println("Pagando $" + monto + " en efectivo.");
        System.out.println("Pago realizado con exito!");
    }
}
