package pe.edu.upeu.service;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import pe.edu.upeu.model.Infraccion;
import pe.edu.upeu.repository.InfraccionRepository;

import java.util.List;
    @Transactional
    @Singleton
    public class InfraccionServiceImp implements InfraccionService {
        private final InfraccionRepository repo;
        public InfraccionServiceImp(InfraccionRepository repo) {
            this.repo = repo;
        }
        @Override
        public Infraccion save(Infraccion c) {
            return repo.save(c);
        }
        @Override
        public Infraccion update(Infraccion c) {
            return repo.update(c);
        }
        @Override
        public List<Infraccion> findAll() {
            return repo.findAll();
        }
        @Override
        public void delete(String id) {
            repo.deleteById(id);
        }
        @Override
        public boolean existsById(String id) {
            return repo.existsById(id);
        }
    }

