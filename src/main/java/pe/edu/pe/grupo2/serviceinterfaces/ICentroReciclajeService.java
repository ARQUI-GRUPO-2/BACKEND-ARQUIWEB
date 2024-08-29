package pe.edu.pe.grupo2.serviceinterfaces;

import pe.edu.pe.grupo2.entities.CentroReciclaje;

import java.util.List;

public interface ICentroReciclajeService {
    public void insert(CentroReciclaje centroReciclaje);
    public List<CentroReciclaje> list();
    public void delete(int idCentroReciclaje);
    public void update(CentroReciclaje centroReciclaje);
}
