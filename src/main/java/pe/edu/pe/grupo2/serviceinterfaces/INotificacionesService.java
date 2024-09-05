package pe.edu.pe.grupo2.serviceinterfaces;

import pe.edu.pe.grupo2.entities.Notificaciones;

import java.util.List;

public interface INotificacionesService {

    public List<Notificaciones> list();
    public void insert(Notificaciones n);
    public Notificaciones listId(int id);
    public void delete(int id);
    public void update(Notificaciones n);



}
