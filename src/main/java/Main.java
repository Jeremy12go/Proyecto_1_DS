import java.util.ArrayList;
import java.util.Scanner;
import models.person.Dueno;

public class Main {
    static Scanner leer = new Scanner(System.in);//cambio de nombre de scanner por costumbre de nose que profe
    private static ArrayList<Dueno> duenos = new ArrayList<>();//Arraylist de los duenios

    public static void registrarDueno() {//En este metodo se realiza el proceso para registrar un nuevo dueño en el sistema (NO HE MANEJADO EXCEPCIONES)
        System.out.print("Escibe tu nombre: ");
        String nombre_dueno = leer.nextLine();
        System.out.print("Escribe tu apellido: ");
        String apellido_dueno = leer.nextLine();
        System.out.print("Escribe tu direccion: ");
        String direccion_dueno = leer.nextLine();
        System.out.print("Escribe tu telefono: ");
        String telefono_dueno = leer.nextLine();
        Dueno nuevoDueno = new Dueno(nombre_dueno, apellido_dueno, direccion_dueno, telefono_dueno);
        duenos.add(nuevoDueno);
        System.out.println("Dueño registrado con éxito");
    }
    public static void main(String[] args) {
        boolean continuar_proceso = true;
        while (continuar_proceso){//mientras el usuario no se quiera ir, el programa seguira funcionando
            System.out.println("\nBienvenido a VetCare APP");
            System.out.println("¿Quien eres?:");
            System.out.println("\n1)Dueño\n2)Veterinario\n3)Soy nuevo y quiero registrarme\n4)Me quiero ir a la chucha");
            System.out.print("\nPor favor escribe el numero de la opcion a elegir: ");
            int opcion_elegida = leer.nextInt();
            leer.nextLine(); //para evitar salto de linea

            switch (opcion_elegida) {
                case 1:
                    if (duenos.isEmpty()) {
                        System.out.println("No hay dueños registrados.");
                        break;
                    }
                    System.out.println("\nLista de dueños registrados:");
                    //Impresion de dueños registrados
                    int contador = 0;
                    while (contador<duenos.size()){
                        Dueno duenoelegido = duenos.get(contador);
                        System.out.println((contador+1) + ".- " + duenoelegido.getNombre() + " " + duenoelegido.getApellido());
                        contador+=1;
                    }
                    System.out.print("Por favor selecciona un dueño (escribe el numero):");
                    opcion_elegida = leer.nextInt();
                    leer.nextLine();
                    Dueno duenoelegido = duenos.get(opcion_elegida-1);
                    duenoelegido.mostrarMenu(); //Se muestra el menu del dueño
                    break;
                case 2:
                    System.out.println("Has seleccionado: Veterinario");
                    break;
                case 3:
                    registrarDueno(); //Comienza el proceso de registro de un nuevo dueño al sistema
                    break;
                case 4:
                    System.out.println("A bueno entonces andate a la chucha"); //siiii que se vaya a la chucha
                    continuar_proceso = false;
                    break;
                default:
                    System.out.println("El digito que ingresaste no es valido");
            }
        }
    }
}
