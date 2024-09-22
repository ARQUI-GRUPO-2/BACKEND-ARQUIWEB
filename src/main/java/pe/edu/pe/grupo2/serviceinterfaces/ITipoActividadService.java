package pe.edu.pe.grupo2.serviceinterfaces;

import pe.edu.pe.grupo2.entities.TipoActividad;

import java.util.List;

public interface ITipoActividadService {
    void insert(TipoActividad tipoactividad);
    List<TipoActividad> list();

    // Métodos para las nuevas queries
    List<TipoActividad> findByInvitacionContaining(String text);
    int countNonEmptyInvitations();
}
