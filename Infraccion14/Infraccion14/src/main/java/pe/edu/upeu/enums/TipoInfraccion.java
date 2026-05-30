package pe.edu.upeu.enums;

import lombok.Getter;

@Getter
public enum TipoInfraccion {

    EXCESO_VELOCIDAD("Exceso de velocidad"),
    MAL_ESTACIONADO("Mal estacionado"),
    SIN_LICENCIA("Sin licencia"),
    LUZ_ROJA("Pasó luz roja"),
    DOCUMENTOS("Documentos vencidos");

    private final String nombre;

    TipoInfraccion(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}