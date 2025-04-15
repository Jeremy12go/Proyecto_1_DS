package models.payments;

import java.io.Serializable;

public class SeguroVeterinario extends Pago implements Serializable {

    private String numeroPoliza;
    private String aseguradora;
    private Float porcentajeCubierto;


    @Override
    public void RealizarPago() {
        System.out.println("Pago realizado con exito!");
    }
}
