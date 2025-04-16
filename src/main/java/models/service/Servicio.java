package models.service;

import lombok.*;
import java.io.Serializable;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Servicio implements Serializable {

    private String nombre;
    private String codigo;
    private String descripcion;
    private int costo;
    private int duracionEnMinuto;
}
