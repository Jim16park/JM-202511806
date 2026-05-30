package pe.edu.upeu.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Id;              // ← ESTE, no jakarta.persistence.Id
import io.micronaut.data.annotation.MappedEntity;    // ← ESTE, no jakarta.persistence.Entity
import io.micronaut.data.annotation.MappedProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@MappedEntity("infraccion")    // ← reemplaza @Entity(name="infraccion")
@Introspected
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Infraccion {

    @Id                        // ← io.micronaut.data.annotation.Id
    @MappedProperty("placa")
    @NotBlank
    private String placa;

    @MappedProperty("nombre")
    private String nombre;

    @MappedProperty("fecha")
    private String fecha;

    @MappedProperty("tipo")
    private String tipo;

    @MappedProperty("monto")
    private Double monto;

    @MappedProperty("estado")
    private String estado;
}