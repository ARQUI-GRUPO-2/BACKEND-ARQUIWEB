package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.pe.grupo2.entities.TipoActividad;

import java.util.List;

@Repository
public interface ITipoActividadRepository extends JpaRepository<TipoActividad, Integer> {

    // Query 1: Listar todas las actividades que contienen un texto específico en la invitación
    @Query("SELECT t FROM TipoActividad t WHERE t.invitacion LIKE %:text%")
    List<TipoActividad> findByInvitacionContaining(String text);

    // Query 2: Contar todas las actividades que tienen una invitación no vacía
    @Query("SELECT COUNT(t) FROM TipoActividad t WHERE t.invitacion IS NOT NULL AND t.invitacion <> ''")
    int countNonEmptyInvitations();
}
