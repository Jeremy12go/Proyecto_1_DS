package models.payments;

public class Efectivo extends Pago {

    @Override
    public void RealizarPago() {
        System.out.println("Pago realizado con exito!");
    }
}
