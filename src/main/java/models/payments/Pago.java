package models.payments;

import lombok.*;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public abstract class Pago implements Serializable {
    protected int monto;

    public abstract void RealizarPago();
}
