package models.payments;

public class SeguroVeterinario extends Pago {

    private String numeroPoliza;
    private String aseguradora;
    private Float porcentajeCubierto;


    @Override
    public void RealizarPago() {
        System.out.println("Pago realizado con exito!");
    }
}
