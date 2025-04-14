package models.payments;

public class Transferencia extends Pago{

    @Override
    public void RealizarPago() {
        System.out.println("Pago realizado con exito!");
    }
}
