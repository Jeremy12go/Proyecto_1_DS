package models.person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import models.appointment.*;
import models.payments.*;
import models.pet.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor
public class Dueno extends Persona implements Serializable {

    private String correo;
    private Direccion Direccion;
    private String numeroContacto;
    private ArrayList<Mascota> mascotas = new ArrayList<>();

    public Dueno(String nombre, String rut, String correo, Direccion Direccion, String numeroContacto) {
        super(nombre, rut);
        this.correo = correo;
        this.Direccion = Direccion;
        this.numeroContacto = numeroContacto;
        this.mascotas = new ArrayList<>();
    }

    /*
     * Método se realiza el registro de una mascota a la lista de mascotas del dueño.
     */

    public void registrarMascota() {

        Scanner scan = new Scanner(System.in);
        String nombre_mascota, especie_mascota, raza_mascota;
        int edad_en_meses_mascota;
        float peso_mascota;
        EstadoSalud estado_salud_mascota;

        while (true) {
            System.out.print("Escribe su nombre: ");
            nombre_mascota = scan.nextLine();
            if (nombre_mascota.trim().isEmpty() || !nombre_mascota.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                System.out.println("Nombre inválido. Solo debe contener letras y no estar vacío.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Escribe su especie: ");
            especie_mascota = scan.nextLine();
            if (especie_mascota.trim().isEmpty() || !especie_mascota.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                System.out.println("Especie inválida. Solo debe contener letras y no estar vacío.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Escribe su raza: ");
            raza_mascota = scan.nextLine();
            if (raza_mascota.trim().isEmpty() || !raza_mascota.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                System.out.println("Raza inválida. Solo debe contener letras y no estar vacío.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Escribe su edad en meses: ");
            edad_en_meses_mascota = scan.nextInt();
            scan.nextLine();// Evitar salto de linea.
            if (edad_en_meses_mascota > 0 && edad_en_meses_mascota <= 360) { // 30 años máx
                break;
            } else {
                System.out.println("Edad inválida. Debe ser mayor que 0 y menor o igual a 360 meses.");
            }
        }

        while (true) {
            System.out.print("Escribe su peso en kg (ej: 7,5): ");
            peso_mascota = scan.nextFloat();
            scan.nextLine();// Evitar salto de linea.
            if (peso_mascota > 0 && peso_mascota <= 200) {
                break;
            } else {
                System.out.println("Peso inválido. Debe ser mayor que 0 y menor o igual a 200 kg.");
            }
        }

        // Mostrar estados de salud.
        int contador = 0;
        EstadoSalud[] estados = EstadoSalud.values();
        while (contador < estados.length){
            System.out.println((contador+1) + ".- " + estados[contador]);
            contador+=1;
        }

        int decision_estado_salud = 0;
        while (true) {
            System.out.print("Escribe el numero del estado de salud de la mascota: ");
            decision_estado_salud = scan.nextInt();
            scan.nextLine();
            if(decision_estado_salud < 1 &&  decision_estado_salud > estados.length){
                System.out.println("La elección "+ decision_estado_salud +" no esta permitida");
            }else{
                // Asignación del estado de salud.
                estado_salud_mascota = estados[4];
                switch (decision_estado_salud){
                    case 1,2,3,4,5:{
                        estado_salud_mascota = estados[decision_estado_salud-1];
                        break;
                    }
                }
                break;
            }
        }

        System.out.println("\n" + nombre_mascota + " tiene microchip? (Ej: 1)");
        System.out.println("1) Si");
        System.out.println("2) No");
        System.out.print("Escribe el numero de la opción a elegir: ");
        int tiene_microchip = scan.nextInt();

        boolean boolean_microchip = false;
        int numero_microchip_mascota = 0;
        scan.nextLine();// Evitar salto de linea.

        switch (tiene_microchip){
            case 1:
                boolean_microchip = true;
                System.out.print("Escribe el numero del microchip: ");
                numero_microchip_mascota = scan.nextInt();
                scan.nextLine();
                break;
            case 2:
                boolean_microchip = false;
                break;
            default:
                System.out.println("Opcion invalida, Se considerara que no tiene microchip");
                boolean_microchip = false;
                break;
        }
        Mascota mascota = new Mascota(nombre_mascota,especie_mascota,raza_mascota,edad_en_meses_mascota,peso_mascota,
                boolean_microchip, numero_microchip_mascota, estado_salud_mascota, null);
        this.mascotas.add(mascota);
        System.out.println("Mascota registrada exitosamente :D!");
    }

    public void citasDeMascota(Mascota mascota) {

        if(!this.mascotas.contains(mascota)){
            System.out.println("Esa no es tu mascota...");
            return;
        }

        ArrayList<Cita> citasMascota = mascota.getCitas();
        if(citasMascota == null){
            System.out.println(mascota.getNombre() + " no tiene citas registradas.");
            return;
        }

        // Mostrar citas
        System.out.println(mascota.getNombre() + " tiene " + citasMascota.size() + " citas: ");
        for(Cita cita : citasMascota){
            System.out.println("Con fecha: " + cita.getFecha().toString()+"\nCon motivo de: " + cita.getMotivo() + "\n");
        }
    }

    public void menuDueno(){
        Scanner scan = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {

            int opcion = 2;

            if (opcion == 2) {
                System.out.println("\nBienvenido " + nombre + "!");
            }
            System.out.println("1) Registrar Mascota");
            System.out.println("2) Mostrar citas de una mascota");
            System.out.println("3) Pagar cita");
            System.out.println("4) Mostrar historial medico de mascota");
            System.out.println("5) Agendar cita para una mascota");
            System.out.println("6) Volver al menu");
            System.out.print("Seleccione una opción: ");
            opcion = scan.nextInt();
            scan.nextLine();// Evitar salto de linea.

            if(opcion < 1 || opcion > 7){
                System.out.println("\n!El digito que ingresaste no es valido¡");
            }else{
                switch (opcion) {
                    case 1:
                        registrarMascota();
                        break;
                    case 2:
                        // Mostrar mascotas.
                        System.out.println("\nListado de sus mascotas: ");
                        int count = 1;
                        for(Mascota mascota : this.mascotas){
                            System.out.println(count+") " + mascota.getNombre());
                            count++;
                        }

                        // Selección mascota.
                        int decision_mascota = 0;
                        while (true){
                            System.out.println("\n| 0 para volver atrás.");
                            System.out.println("Escribe el numero de la mascota a la cual le quiere ver las citas: ");
                            decision_mascota = scan.nextInt();
                            scan.nextLine();// Evitar salto de linea.

                            if(decision_mascota < 0 || decision_mascota > this.mascotas.size()){
                                System.out.println("El numero de la mascota no existe");
                            }else if(decision_mascota != 0){
                                citasDeMascota(this.mascotas.get(decision_mascota-1));
                                break;
                            }else{
                                break;
                            }
                        }
                        break;
                    case 3:
                        // Mostrar Citas de mascotas con su costo.
                        System.out.println("\nListado de citas por mascota: ");
                        ArrayList<Cita> citasDisponiblesPago = new ArrayList<>();
                        count = 1;
                        for(Mascota mascota : this.mascotas){
                            ArrayList<Cita> citas = mascota.getCitas();
                            for(Cita cita : citas){
                                System.out.println(count+") " + mascota.getNombre() + " tiene cita con valor"
                                        + cita.calcularCostoTotal() + "Y estado" + cita.getEstado());
                                citasDisponiblesPago.add(cita);
                                count++;
                            }
                        }

                        // Selección cita a pagar.
                        int decision_cita = 0;
                        while (true){
                            System.out.println("\n| 0 para volver atrás.");
                            System.out.println("Escribe el numero de la cita a pagar: ");
                            decision_cita = scan.nextInt();
                            scan.nextLine();// Evitar salto de linea.

                            if(decision_cita < 0 || decision_cita > count-1){
                                System.out.println("El numero de cita no existe");
                            }else if(decision_cita != 0){
                                Cita citaA_Pagar = citasDisponiblesPago.get(decision_cita-1);
                                //PERO ESPERA
                                if (citaA_Pagar.getEstado().contains(EstadoCita.PAGADO)){
                                    System.out.println("Esta cita ya esta pagaada :)");
                                    break;
                                }
                                // Selección de método de pago.
                                menuSeleccionPago(citaA_Pagar);

                                break;
                            }else{
                                break;
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Mostrar historial medico de mascota");
                        break;
                    case 5:
                        System.out.println("Agendar cita para una mascota");
                        break;
                    case 6:
                        System.out.println();
                        continuar = false;
                        break;
                }
            }
        }
    }

    public void menuSeleccionPago(Cita cita) {
        Scanner scan = new Scanner(System.in);
        int monto = cita.calcularCostoTotal();
        System.out.println("El costo total es de: " + monto);
        Pago pago = null;


        while (true) {
            System.out.println("\nMétodos de pago disponibles:");
            System.out.println("1) Tarjeta");
            System.out.println("2) Efectivo");
            System.out.println("3) Seguro Veterinario");
            System.out.println("0) Cancelar");

            System.out.print("Selecciona el método de pago: ");
            int opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese tipo de tarjeta (Crédito/Débito): ");
                    String tipo = scan.nextLine();

                    System.out.print("Ingrese número de tarjeta: ");
                    String numero = scan.nextLine();

                    System.out.print("Ingrese nombre del titular: ");
                    String titular = scan.nextLine();

                    System.out.print("Ingrese año de expiración (AAAA): ");
                    int anio = scan.nextInt();
                    System.out.print("Ingrese mes de expiración (1-12): ");
                    int mes = scan.nextInt();
                    scan.nextLine();

                    pago = new Tarjeta(monto, tipo, numero, titular, LocalDate.of(anio, mes, 1));
                    break;

                case 2:
                    pago = new Efectivo(monto);
                    pago.RealizarPago();
                    cita.getEstado().remove(EstadoCita.NO_PAGADO);
                    cita.getEstado().add(EstadoCita.PAGADO);
                    break;

                case 3:
                    System.out.print("Ingrese número de póliza: ");
                    String poliza = scan.nextLine();

                    System.out.print("Ingrese nombre de la aseguradora: ");
                    String aseguradora = scan.nextLine();

                    System.out.print("Ingrese porcentaje cubierto (ej. 0.8 para 80%): ");
                    float porcentaje = scan.nextFloat();
                    scan.nextLine();

                    pago = new SeguroVeterinario(monto, poliza, aseguradora, porcentaje);
                    break;

                case 0:
                    System.out.println("Pago cancelado.");
                    return;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    continue;
            }

            // Asignar y ejecutar pago.
            cita.setPago(pago);
            cita.getEstado().remove(EstadoCita.NO_PAGADO);
            cita.getEstado().add(EstadoCita.PAGADO);
            break;
        }
    }

}
