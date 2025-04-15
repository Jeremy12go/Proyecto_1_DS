package models.payments;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pago implements Serializable {
    protected int monto;

    public abstract void RealizarPago();
}
