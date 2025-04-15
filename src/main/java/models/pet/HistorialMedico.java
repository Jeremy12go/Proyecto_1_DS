package models.pet;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class HistorialMedico implements Serializable {

    private Date fecha;
    private String observacion;
    private String diagnostico;
    private String tratamiento;
    private boolean controlFuturo;

}
