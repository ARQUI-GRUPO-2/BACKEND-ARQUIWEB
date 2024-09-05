package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.pe.grupo2.entities.Notificaciones;

public interface INotificacionesRepository extends JpaRepository<Notificaciones, Integer> {
}
