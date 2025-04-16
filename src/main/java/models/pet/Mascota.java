package models.pet;

import lombok.*;
import models.appointment.Cita;
import java.io.Serializable;
import java.util.ArrayList;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Mascota implements Serializable {

    private String nombre;
    private String especie;
    private String raza;
    private int edadEnMeses;
    private float peso;
    private boolean posesionMicrochip;
    private int numeroMicrochip;
    private EstadoSalud estadoSalud;
    private ArrayList<Cita> citas = new ArrayList<>();
    
    public Mascota(String nombre, String especie, String raza, int edadEnMeses, float peso, boolean posesionMicrochip, EstadoSalud estadoSalud) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edadEnMeses = edadEnMeses;
        this.peso = peso;
        this.posesionMicrochip = posesionMicrochip;
        this.estadoSalud = estadoSalud;
        this.citas = new ArrayList<>();
    }


    public void definirNumeroMicrochip(){}

}
