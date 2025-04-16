package models.payments;

import java.io.Serializable;

public class SeguroVeterinario extends Pago implements Serializable {

    private String numeroPoliza;
    private String aseguradora;
    private Float porcentajeCubierto;

    public SeguroVeterinario(int monto, String poliza, String aseguradora, float porcentaje) {
    }

    @Override
    public void RealizarPago() {
        int cubierto = (int)(monto * porcentajeCubierto);
        int restante = monto - cubierto;
        System.out.println("El seguro cubre $" + cubierto + ". El dueño paga $" + restante);
        System.out.println("Pago realizado mediante seguro de " + aseguradora);
        System.out.println("Pago realizado con exito!");
    }
}
