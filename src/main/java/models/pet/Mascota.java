package models.pet;

public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private int edadEnMeses;
    private float peso;
    private boolean posesionMicrochip;
    private int numeroMicrochip;
    private EstadoSalud estadoSalud;

    public Mascota(String nombre, String especie, String raza, int edadEnMeses, float peso, boolean posesionMicrochip,int numeroMicrochip, EstadoSalud estadoSalud) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edadEnMeses = edadEnMeses;
        this.peso = peso;
        this.posesionMicrochip = posesionMicrochip;
        this.estadoSalud = estadoSalud;
    }
}
