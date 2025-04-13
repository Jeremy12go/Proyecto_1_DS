package models.appointment;

import models.person.Veterinario;
import models.pet.Mascota;

import java.util.Date;

public class Cita {

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
