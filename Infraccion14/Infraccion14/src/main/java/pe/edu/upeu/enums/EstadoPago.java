package pe.edu.upeu.enums;

import lombok.Getter;

@Getter
public enum EstadoPago {

    PENDIENTE("Pendiente"),
    PAGADA("Pagada");

    private final String nombre;

    EstadoPago(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}