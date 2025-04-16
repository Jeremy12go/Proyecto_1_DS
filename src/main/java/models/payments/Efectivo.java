package models.payments;

import java.io.Serializable;

public class Efectivo extends Pago implements Serializable {

     public Efectivo(int monto) {
          this.monto = monto;
     }

     @Override
    public void RealizarPago() {
        System.out.println("Pagando $" + this.monto + " en efectivo.");
        System.out.println("Pago realizado con exito!");
    }
}
