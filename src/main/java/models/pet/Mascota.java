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

    public void  agregarCita(Cita cita){
        this.citas.add(cita);
    }

}
