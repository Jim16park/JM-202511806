package pe.edu.upeu.repository;

import pe.edu.upeu.model.Infraccion;
import java.util.ArrayList;
import java.util.List;

public class InfraccionRepository {

    private List<Infraccion> lista = new ArrayList<>();

    public void guardar(Infraccion i){
        lista.add(i);
    }

    public List<Infraccion> listar(){
        return lista;
    }

    public void eliminar(int index){
        if(index >= 0 && index < lista.size()){
            lista.remove(index);
        }
    }

    public List<Infraccion> filtrarPorEstado(String estado){
        List<Infraccion> nueva = new ArrayList<>();
        for(Infraccion i : lista){
            if(i.getEstado() != null && i.getEstado().equalsIgnoreCase(estado)){
                nueva.add(i);
            }
        }
        return nueva;
    }
}