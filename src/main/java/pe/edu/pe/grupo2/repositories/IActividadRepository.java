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
    @Query(value = "SELECT \n" +
            "    c.id_centro_reciclaje AS id_centro_reciclaje, \n" +
            "    COUNT(a.id_actividad) AS numero_actividades\n" +
            "FROM \n" +
            "    actividad a\n" +
            "INNER JOIN \n" +
            "    centro_reciclaje c ON a.id_centro_reciclaje = c.id_centro_reciclaje\n" +
            "GROUP BY \n" +
            "    c.id_centro_reciclaje", nativeQuery = true)
    public List<String[]> ActividadesporCentro();
    @Query(value = "SELECT \n" +
            "    u.id_user AS id_user, \n" +
            "    COUNT(a.id_actividad) AS numero_actividades, \n" +
            "    SUM(CAST(a.puntos AS INTEGER)) AS total_puntos\n" +
            "FROM \n" +
            "    actividad a \n" +
            "INNER JOIN \n" +
            "    usuario u ON a.id_user = u.id_user\n" +
            "GROUP BY \n" +
            "    u.id_user", nativeQuery = true)
    public List<String[]> ActividadesporUsuario();
}
