package models.appointment;

import lombok.*;
import models.payments.Pago;
import models.person.Veterinario;
import models.pet.Mascota;
import models.service.Servicio;
import java.io.Serializable;
import java.util.Date;
import java.util.EnumSet;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Cita implements Serializable {

    private Date fecha;
    private String motivo;
    private EnumSet<EstadoCita> estado = EnumSet.of(EstadoCita.PENDIENTE, EstadoCita.NO_PAGADO);
    private Mascota mascotaAsignada;
    private Veterinario veterinarioAsignado;
    private Servicio servicioAsignado;
    private Pago pago;

    public Cita(Date from, String motivo, Mascota mascota, Veterinario vet, Servicio servicio) {
        this.fecha = from;
        this.motivo = motivo;
        this.mascotaAsignada = mascota;
        this.veterinarioAsignado = vet;
        this.servicioAsignado = servicio;
    }

    public void asignarServicio(Servicio servicio) {
        this.servicioAsignado = servicio;
    }

    public void agendar(){}

    public int calcularCostoTotal(){
        if (servicioAsignado != null) {
            return servicioAsignado.getCosto();
        } else {
            return 0;
        }
    }

}
