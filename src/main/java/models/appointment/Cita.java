package models.appointment;

import lombok.*;
import models.person.Veterinario;
import models.pet.Mascota;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita implements Serializable {

    private Date fecha;
    private String motivo;
    private EstadoCita estado;
    private Mascota mascotaAsignada;
    private Veterinario veterinarioAsignado;

    public void Agendar(){}

    public void AsignarServicio(){}

    public int CalcularCostoTotal(){
        return 0;
    }

}
