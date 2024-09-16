package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.pe.grupo2.entities.Actividad;

import java.util.List;

@Repository
public interface IActividadRepository extends JpaRepository<Actividad,Integer> {
    @Query("select ac from Actividad ac where ac.nombre like %:nombre%")
    public List<Actividad> buscarNombre(@Param("nombre")String nombre);
    @Query(value = "SELECT \n" +
            "    actividad.nombre AS nombre,\n" +
            "    actividad.puntos AS puntos,\n" +
            "    recompensas.nombre_recompensa AS nombre_recompensa\n" +
            "FROM \n" +
            "    actividad\n" +
            "JOIN \n" +
            "    recompensas\n" +
            "ON \n" +
            "    actividad.id_actividad = recompensas.id_actividad", nativeQuery = true)
    public List<String[]> puntosxactividad();
}
