package pe.edu.upeu.service;

import pe.edu.upeu.model.Infraccion;
import java.util.List;
    public interface InfraccionService {
        Infraccion save(Infraccion c);
        Infraccion update(Infraccion c);
        List<Infraccion> findAll();
        void delete(String id);
        boolean existsById(String id);
    }

