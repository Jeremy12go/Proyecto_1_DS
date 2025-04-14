package models.person;
import java.util.ArrayList;
import java.util.Scanner;
import models.pet.EstadoSalud;
import models.pet.Mascota;
public class Dueno extends Persona {
    static Scanner leer = new Scanner(System.in);
    private static ArrayList<Mascota> mascotas = new ArrayList<>();
    private String direccion;
    private String telefono;
    public Dueno(String nombre, String apellido, String direccion, String telefono) {
        super(nombre, apellido);
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public static void registrarMascota() {//En este metodo se realiza el proceso de registro de una mascota a la lista de mascotas del dueño
        System.out.print("Escribe su nombre: ");
        String nombre_mascota = leer.nextLine();
        System.out.print("Escribe su especie: ");
        String especie_mascota = leer.nextLine();
        System.out.print("Escribe su raza: ");
        String raza_mascota = leer.nextLine();
        System.out.print("Escribe su edad en meses: ");
        int edad_en_meses_mascota = leer.nextInt();
        leer.nextLine();
        System.out.print("Escribe su peso: ");
        float peso_mascota = leer.nextFloat();
        leer.nextLine();
        //Impresion de estados de salud
        int contador = 0;
        EstadoSalud[] estados = EstadoSalud.values();
        while (contador< estados.length){
            System.out.println((contador+1) + ".- " + estados[contador]);
            contador+=1;
        }
        System.out.print("Escribe el numero del estado de salud de la mascota: ");
        int decision_estado_salud = leer.nextInt();
        leer.nextLine();
        //La variable para el estado de salud se crea aqui porque no me deja crearlo dentro de los switch xd
        EstadoSalud estado_salud_mascota = estados[4];
        switch (decision_estado_salud){
            case 1,2,3,4,5:{
                estado_salud_mascota = estados[decision_estado_salud-1];
                break;
            }
            default:{
                System.out.println("Digito escrito invalido, se considerara que su perro esta bien");
                break;
            }
        }
        System.out.println("Tu perro tiene microchip?");
        System.out.println("1)Si");
        System.out.println("2)No");
        System.out.print("Escribe el numero de la opcion a elegir: ");
        int tiene_microchip = leer.nextInt();
        boolean boolean_microchip = false;
        int numero_microchip_mascota = 0;
        leer.nextLine();
        switch (tiene_microchip){
            case 1:
                boolean_microchip = true;
                System.out.print("Escribe el numero del microchip: ");
                numero_microchip_mascota = leer.nextInt();
                leer.nextLine();
                break;
            case 2:
                boolean_microchip = false;
                break;
            default:
                System.out.println("Opcion invalida, Se considerara que no tiene microchip");
                boolean_microchip = false;
                break;
        }
        Mascota mascota = new Mascota(nombre_mascota,especie_mascota,raza_mascota,edad_en_meses_mascota,peso_mascota,boolean_microchip, numero_microchip_mascota,  estado_salud_mascota);
        mascotas.add(mascota);
        System.out.println("Mascota registrada exitosamente");
    }

    public void mostrarMenu(){
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú de Dueño: " + nombre + " " + apellido);
            System.out.println("1) Añadir Mascota");
            System.out.println("2) Mostrar citas de una mascota");
            System.out.println("3) Pagar cita");
            System.out.println("4) Mostrar historial medico de mascota");
            System.out.println("5) ME QUIERO IR");
            System.out.print("Seleccione una opción: ");
            int opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    registrarMascota();//Comienza el registro de la nueva mascota
                    break;
                case 2:
                    System.out.print("Mostrar citas de una mascota");
                    break;
                case 3:
                    System.out.println("Pagar cita");
                    break;
                case 4:
                    System.out.println("Mostrar historial medico de mascota");
                    break;
                case 5:
                    System.out.println("A bueno andate a la chucha");
                    continuar = false;
                default:
                    System.out.println("Por favor escoje una opcion valida");
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }
}
