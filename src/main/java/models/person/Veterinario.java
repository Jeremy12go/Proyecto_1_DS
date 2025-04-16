package models.person;
import lombok.*;
import models.appointment.Cita;
import models.service.Servicio;
import models.appointment.EstadoCita;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

@Getter @Setter @NoArgsConstructor
public class Veterinario extends Persona implements Serializable {

    private String especialidad;
    private ArrayList<Cita> disponibilidad = new ArrayList<>();

    public Veterinario (String nombre, String rut, String especialidad) {
        super(nombre, rut);
        this.especialidad = especialidad;
    }

    public Veterinario(String s, String s1, String general, ArrayList<Cita> disponibilidad) {
    }

    public void menuVeterinario(ArrayList<Servicio> servicios) {
        Scanner scan = new Scanner(System.in);

        // Mostrar citas del día.
        System.out.println("\nListado de citas del día:");
        int count = 1;
        for (Cita cita : this.disponibilidad) {
            System.out.println(count + ") " + cita.getFecha() + " - Mascota: " + cita.getMascotaAsignada().getNombre());
            count++;
        }

        // Selección de cita.
        System.out.println("\n| 0 para volver atrás.");
        System.out.print("Escribe el número de la cita a atender: ");
        int decision_cita = scan.nextInt();
        scan.nextLine();

        if (decision_cita == 0) return;
        if (decision_cita < 1 || decision_cita > this.disponibilidad.size()) {
            System.out.println("Número de cita no válido.");
            return;
        }

        Cita citaSeleccionada = this.disponibilidad.get(decision_cita - 1);

        // Mostrar servicios disponibles.
        System.out.println("\nServicios disponibles:");
        for (int i = 0; i < servicios.size(); i++) {
            Servicio s = servicios.get(i);
            System.out.println((i + 1) + ") " + s.getNombre());
        }

        // Selección de servicio.
        System.out.print("Selecciona un servicio para la cita: ");
        int decision_servicio = scan.nextInt();
        scan.nextLine();

        if (decision_servicio < 1 || decision_servicio > servicios.size()) {
            System.out.println("Número de servicio no válido.");
            return;
        }

        Servicio servicioSeleccionado = servicios.get(decision_servicio - 1);

        // Atender
        this.atender(citaSeleccionada, servicioSeleccionado);
    }


    public void atender(Cita cita, Servicio servicio) {
        if (cita != null && servicio != null) {
            cita.asignarServicio(servicio);
            cita.getEstado().remove(EstadoCita.PENDIENTE);
            cita.getEstado().add(EstadoCita.REALIZADO); // o el que corresponda
            System.out.println("\nServicio asignado exitosamente.");
        } else {
            System.out.println("No se puede atender la cita. Datos incompletos.");
        }
    }
}
