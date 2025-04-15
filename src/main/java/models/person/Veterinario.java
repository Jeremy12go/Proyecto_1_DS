package models.person;
import lombok.*;
import models.appointment.Cita;

import java.io.Serializable;
import java.util.ArrayList;

@Getter @Setter @NoArgsConstructor
public class Veterinario extends Persona implements Serializable {

    private String especialidad;
    private ArrayList<Cita> disponibilidad;

    public Veterinario (String nombre, String rut, String especialidad) {
        super(nombre, rut);
        this.especialidad = especialidad;
    }

}
