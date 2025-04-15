package models.service;

import lombok.Data;
import java.io.Serializable;

@Data
public class Servicio implements Serializable {

    private String nombre;
    private String codigo;
    private String descripcion;
    private int costo;
    private int duracionEnMinuto;

}
