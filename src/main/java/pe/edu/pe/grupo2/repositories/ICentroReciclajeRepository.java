package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.pe.grupo2.entities.CentroReciclaje;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface ICentroReciclajeRepository extends JpaRepository<CentroReciclaje, Integer> {
    @Query("SELECT acr FROM CentroReciclaje acr WHERE acr.direccion LIKE %:direccion%")
    public List<CentroReciclaje> findByDireccion(@Param("direccion") String direccion);
    @Query(value = "SELECT  a.nombre, cr.direccion \n" +
            "FROM CentroReciclaje cr \n" +
            "JOIN Actividad a ON a.cr.idCentroReciclaje = cr.idCentroReciclaje \n" +
            "WHERE a.nombre = 'Invitar' \n")
    public List<String[]> actividadxnombre();
}

