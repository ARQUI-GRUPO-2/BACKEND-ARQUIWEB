package pe.edu.pe.grupo2.serviceinterfaces;

import pe.edu.pe.grupo2.entities.Recompensas;

import java.util.List;

public interface IRecompensasService {
    public void insert(Recompensas recompensas);

    public List<Recompensas> list();

    public void delete(int idRecompensas);

    Recompensas listId(int idRecompensas);

    public void update(Recompensas vehicle);
}