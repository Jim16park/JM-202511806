package pe.edu.upeu.repository;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import pe.edu.upeu.model.Infraccion;
import java.util.List;

@JdbcRepository(dialect = Dialect.H2)
public interface InfraccionRepository extends CrudRepository<Infraccion, String> {
    List<Infraccion> findByNombreContainsIgnoreCase(String nombre);
    List<Infraccion> findByPlacaContains(String placa);
}