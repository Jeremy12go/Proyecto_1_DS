import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import Repository.RepositoryManager;
import models.appointment.Cita;
import models.person.Direccion;
import models.person.Dueno;
import models.person.Veterinario;
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

    public static void main(String[] args) {

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
                    // Todo: Cargar VETERINARIOS
                    System.out.println("Has seleccionado: Veterinario");
                    break;
                case 3:
                    registrarDueno();
                    // Guardado de datos.
                    repo.saveDataList(duenos,"duenos.dat");
                    break;
                case 4:
                    System.out.println("\nEsperamos volver a verte pronto :D!\n");

                    // Guardado de datos.
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
}
