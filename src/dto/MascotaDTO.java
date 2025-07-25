package dto;

import java.io.Serializable;

public class MascotaDTO implements Serializable {
    private String nombre;
    private String especie;
    private int edad;

    public MascotaDTO(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public int getEdad() { return edad; }

    @Override
    public String toString() {
        return nombre + " - " + especie + " - " + edad + " años";
    }
}
