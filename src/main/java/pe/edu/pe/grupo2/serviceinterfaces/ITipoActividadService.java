package pe.edu.pe.grupo2.serviceinterfaces;

import pe.edu.pe.grupo2.entities.TipoActividad;

import java.util.List;

public interface ITipoActividadService {
    public void insert(TipoActividad tipoactividad);
    public List<TipoActividad> list();
}
