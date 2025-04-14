package models.service;

import lombok.Data;

@Data
public class Servicio {

    private String nombre;
    private String codigo;
    private String descripcion;
    private int costo;
    private int duracionEnMinuto;

}
