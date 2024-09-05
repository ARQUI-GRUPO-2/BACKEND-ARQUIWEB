package pe.edu.pe.grupo2.serviceinterfaces;

import pe.edu.pe.grupo2.entities.Actividad;

import java.util.List;

public interface IActividadService {
    public List<Actividad> list();
    public void insert(Actividad a);
    public Actividad listId(int id);
    public void update(Actividad a);
    public void delete(int id);
    public List<Actividad> buscarNombre(String nombre);

}
