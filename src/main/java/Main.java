import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import Repository.RepositoryManager;
import models.appointment.Cita;
import models.appointment.EstadoCita;
import models.person.Direccion;
import models.person.Dueno;
import models.person.Veterinario;
import models.pet.EstadoSalud;
import models.pet.Mascota;
import models.service.Servicio;

public class Main implements Serializable {

    static Scanner scan = new Scanner(System.in);

    private static ArrayList<Dueno> duenos = new ArrayList<>();
    private static ArrayList<Veterinario> veterinarios;
    private static ArrayList<Servicio> servicios;

    /**
     * Método que realiza el proceso para registrar un nuevo dueño en el sistema, con su respectiva dirección
     * validando cada entrada.
     */
    public static void registrarDueno() {

        String nombre_dueno, rut_dueno, correo_dueno, telefono_dueno, direccionRegion, direccionCiudad,
                direccionPoblacion, direccionNumeroCasa;

        while (true) {
            System.out.print("Ingrese su Nombre: ");
            nombre_dueno = scan.nextLine();
            if (nombre_dueno.trim().isEmpty() || !nombre_dueno.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                System.out.println("Nombre inválido. Solo debe contener letras y no estar vacío.");
            }else{
                break;
            }
        }

        while (true) {
            System.out.print("Ingrese su RUT: ");
            rut_dueno = scan.nextLine();
            if (!rut_dueno.matches("^\\d{1,2}\\.?\\d{3}\\.?\\d{3}-[\\dkK]$")) {
                System.out.println("RUT inválido. Formato correcto: 12.345.678-9");
            }else{
                break;
            }
        }

        while (true) {
            System.out.print("Ingrese su Correo: ");
            correo_dueno = scan.nextLine();
            if (!correo_dueno.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("Correo inválido.");
            }else{
                break;
            }
        }

        while (true) {
            System.out.print("Ingrese su Teléfono: ");
            telefono_dueno = scan.nextLine();
            if (!telefono_dueno.matches("^9\\d{8}$")) {
                System.out.println("Teléfono inválido. Debe contener 9 dígitos y comenzar con 9.");
            }else{
                break;
            }
        }


        System.out.println("Ingrese los siguientes datos de Dirección");
        while (true) {
            System.out.print("Ingrese su REGION en que se ubica: ");
            direccionRegion = scan.nextLine();
            if (direccionRegion.trim().isEmpty()) {
                System.out.println("Región no puede estar vacía.");
            }else{
                break;
            }
        }

        while (true) {
            System.out.print("Ingrese su CIUDAD en que se ubica: ");
            direccionCiudad = scan.nextLine();
            if (direccionCiudad.trim().isEmpty()) {
                System.out.println("Ciudad no puede estar vacía.");
            }else{
                break;
            }
        }

        while (true) {
            System.out.print("Ingrese su POBLACIÓN/VILLA en que se ubica: ");
            direccionPoblacion = scan.nextLine();
            if (direccionPoblacion.trim().isEmpty()) {
                System.out.println("Población/Villa no puede estar vacía.");
            }else{
                break;
            }
        }

        while (true) {
            System.out.print("Ingrese su Número de Casa: ");
            direccionNumeroCasa = scan.nextLine();
            if (!direccionNumeroCasa.matches("\\d+")) {
                System.out.println("Número de casa inválido. Debe contener solo números.");
            }else{
                break;
            }
        }


        Direccion direccion =  new Direccion(direccionRegion,direccionCiudad,direccionPoblacion,direccionNumeroCasa);
        Dueno nuevoDueno = new Dueno(nombre_dueno, rut_dueno, correo_dueno, direccion, telefono_dueno);

        duenos.add(nuevoDueno);
        System.out.println("Dueño registrado con éxito");
    }

    public static void cargarDatosSimulados() {
        // Servicios
        Servicio vacuna = new Servicio("Vacunación", "S001", "Vacuna antirrábica anual", 15000, 20);
        Servicio desparasitacion = new Servicio("Desparasitación", "S002", "Control de parásitos internos", 12000, 15);
        Servicio corteUñas = new Servicio("Corte de uñas", "S003", "Corte y limpieza", 8000, 10);
        servicios.add(vacuna);
        servicios.add(desparasitacion);
        servicios.add(corteUñas);

        // Direcciones
        Direccion dir1 = new Direccion("Maule", "Talca", "San Miguel", "123");
        Direccion dir2 = new Direccion("Metropolitana", "Santiago", "Ñuñoa", "456");

        // Dueños
        Dueno dueno1 = new Dueno("Cristina Morales", "12.345.678-9", "cristina@mail.com", dir1, "912345678");
        Dueno dueno2 = new Dueno("José Pizarro", "22.222.222-2", "jose@mail.com", dir2, "987654321");

        // Mascotas
        Mascota max = new Mascota("Max", "Perro", "Labrador", 36, 25.0f, true, 100001, EstadoSalud.NORMAL, new ArrayList<>());
        Mascota kitty = new Mascota("Kitty", "Gato", "Persa", 18, 4.2f, false, 0, EstadoSalud.ALERGIA_A, new ArrayList<>());
        Mascota luna = new Mascota("Luna", "Perro", "Poodle", 12, 6.5f, true, 100002, EstadoSalud.NORMAL, new ArrayList<>());

        dueno1.getMascotas().add(max);
        dueno1.getMascotas().add(kitty);
        dueno2.getMascotas().add(luna);

        duenos.add(dueno1);
        duenos.add(dueno2);

        // Veterinarios
        Veterinario vet1 = new Veterinario("Dra. Carolina Soto", "17.111.111-1", "General");
        Veterinario vet2 = new Veterinario("Dr. Andrés Ruiz", "18.222.222-2", "Felinos");

        veterinarios.add(vet1);
        veterinarios.add(vet2);

        // Fechas fijas para las citas
        LocalDate fecha1 = LocalDate.of(2025, 4, 20);
        LocalDate fecha2 = LocalDate.of(2025, 4, 22);
        LocalDate fecha3 = LocalDate.of(2025, 4, 25);

        // Citas manuales
        Cita cita1 = new Cita(
                Date.from(fecha1.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                "Control anual",
                max,
                vet1,
                vacuna
        );
        cita1.setEstado(EnumSet.of(EstadoCita.PENDIENTE, EstadoCita.NO_PAGADO));

        Cita cita2 = new Cita(
                Date.from(fecha2.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                "Revisión por picazón",
                kitty,
                vet2,
                desparasitacion
        );
        cita2.setEstado(EnumSet.of(EstadoCita.PENDIENTE, EstadoCita.NO_PAGADO));

        Cita cita3 = new Cita(
                Date.from(fecha3.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                "Corte de uñas y chequeo",
                luna,
                vet1,
                corteUñas
        );
        cita3.setEstado(EnumSet.of(EstadoCita.PENDIENTE, EstadoCita.NO_PAGADO));

        // Asignar citas a mascotas
        max.getCitas().add(cita1);
        kitty.getCitas().add(cita2);
        luna.getCitas().add(cita3);

        // Asignar citas a veterinarios
        vet1.getDisponibilidad().add(cita1);
        vet1.getDisponibilidad().add(cita3);
        vet2.getDisponibilidad().add(cita2);
    }


    public static void funcionalidadPrincipal(){
        // Cargar datos guardados.
        RepositoryManager repo = new RepositoryManager();
        duenos = (ArrayList<Dueno>) repo.loadDataList("duenos.dat");
        veterinarios = (ArrayList<Veterinario>) repo.loadDataList("veterinarios.dat");
        servicios = (ArrayList<Servicio>) repo.loadDataList("servicios.dat");

        // Bucle de ejecución.
        boolean continuar_proceso = true;
        while (continuar_proceso){

            System.out.println("\nBienvenido a VetCare APP");
            System.out.println("¿Quien eres?:");
            System.out.println("\n1)Dueño\n2)Veterinario\n3)Soy nuevo, quiero registrarme\n4)Salir");
            System.out.print("\nPor favor escribe el numero de la opción a elegir (ej: 1):");

            int opcion_elegida = scan.nextInt();
            scan.nextLine();// Evitar salto de linea.
            System.out.println("Eleccion:" + opcion_elegida);

            switch (opcion_elegida) {
                case 1:
                    if (duenos.isEmpty()) {
                        System.out.println("No hay dueños registrados.");
                        break;
                    }else{
                        System.out.println("\nLista de dueños registrados:");

                        // Mostrar dueños registrados.
                        int contador = 0;
                        while (contador<duenos.size()){
                            Dueno duenoelegido = duenos.get(contador);
                            System.out.println((contador+1) + ".- " + duenoelegido.getNombre() + "\n");
                            contador+=1;
                        }

                        while (true){
                            System.out.println("| 0 para volver atrás ");
                            System.out.print("Por favor selecciona un dueño (escribe el numero): ");

                            opcion_elegida = scan.nextInt();
                            scan.nextLine(); // Evitar salto de linea.

                            if(opcion_elegida != 0 && duenos.size() >= opcion_elegida){
                                Dueno duenoelegido = duenos.get(opcion_elegida-1);

                                // Muestra el menu de opciones del dueño.
                                duenoelegido.menuDueno();

                                // Guardado de datos.
                                repo.saveDataList(duenos,"duenos.dat");

                                // Salir del ciclo dueno.
                                break;

                            }else if (opcion_elegida == 0){
                                break;
                            }else{
                                System.out.println("La elección "+ opcion_elegida +" no esta permitida");
                            }
                        }
                    }
                    break;
                case 2:
                    if (veterinarios.isEmpty()) {
                        System.out.println("No hay veterinarios registrados.");
                        break;
                    }else{
                        System.out.println("\nLista de veterinarios registrados:");

                        // Mostrar veterinarios registrados.
                        int contador = 0;
                        while (contador<veterinarios.size()){
                            Veterinario veterinarioElegido = veterinarios.get(contador);
                            System.out.println((contador+1) + ".- " + veterinarioElegido.getNombre() + "\n");
                            contador+=1;
                        }

                        while (true){
                            System.out.println("| 0 para volver atrás ");
                            System.out.print("Por favor selecciona un veterinario (escribe el numero): ");

                            opcion_elegida = scan.nextInt();
                            scan.nextLine(); // Evitar salto de linea.

                            if(opcion_elegida != 0 && veterinarios.size() >= opcion_elegida){
                                Veterinario veterinarioElegido = veterinarios.get(opcion_elegida-1);

                                // Muestra el menu de opciones del dueño.
                                veterinarioElegido.menuVeterinario(servicios);

                                // Guardado de datos.
                                repo.saveDataList(duenos,"duenos.dat");

                                // Salir del ciclo veterinario.
                                break;
                            }else if (opcion_elegida == 0){
                                break;
                            }else{
                                System.out.println("La elección "+ opcion_elegida +" no esta permitida");
                            }
                        }
                    }
                    break;
                case 3:
                    registrarDueno();
                    // Guardado de datos.
                    repo.saveDataList(duenos,"duenos.dat");
                    break;
                case 4:
                    System.out.println("\nEsperamos volver a verte :D!\n");
                    // Guardado de datos.
                    cargarDatosSimulados();
                    repo.saveDataList(duenos,"duenos.dat");
                    repo.saveDataList(veterinarios,"veterinarios.dat");
                    repo.saveDataList(servicios,"servicios.dat");

                    continuar_proceso = false;
                    break;
                default:
                    System.out.println("El digito que ingresaste no es valido");
            }
        }
    }


    public static void main(String[] args) {
        funcionalidadPrincipal();
    }
}
