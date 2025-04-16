package models.appointment;

import lombok.*;
import models.person.Veterinario;
import models.pet.Mascota;
import models.service.Servicio;
import java.io.Serializable;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Cita implements Serializable {

    private Date fecha;
    private String motivo;
    private EstadoCita estado;
    private Mascota mascotaAsignada;
    private Veterinario veterinarioAsignado;
    private Servicio servicioAsignado;

    public void asignarServicio(Servicio servicio) {
        this.servicioAsignado = servicio;
    }

    public void agendar(){}

    public void asignarServicio(){}

    public int calcularCostoTotal(){
        if (servicioAsignado != null) {
            return servicioAsignado.getCosto();
        } else {
            return 0;
        }
    }

}
