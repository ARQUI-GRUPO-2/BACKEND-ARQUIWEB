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


    //CONSULTA PARA HUB09
    @Query(value = "SELECT c.direccion, COUNT(a.id_actividad) AS cantidad_visitas\n" +
            "FROM centro_reciclaje c\n" +
            "JOIN Actividad a ON c.id_centro_reciclaje = a.id_centro_reciclaje\n" +
            "WHERE c.direccion LIKE '%parte_direccion%'\n" +
            "GROUP BY c.direccion\n" +
            "ORDER BY cantidad_visitas DESC;", nativeQuery = true)
    public  List<String[]> masVisitasCentro(@Param("direccion") String direccion);

    //CONSULTA PARA HUB10
    @Query (value = "SELECT c.direccion, \n" +
            "       COUNT(a.id_actividad) AS total_actividades, \n" +
            "       SUM(CAST(a.cantidad AS numeric)) AS total_reciclado\n" +
            "FROM centro_reciclaje c\n" +
            "JOIN Actividad a ON c.id_centro_reciclaje = a.id_centro_reciclaje\n" +
            "GROUP BY c.direccion\n" +
            "HAVING COUNT(a.id_actividad) > 10 AND SUM(CAST(a.cantidad AS numeric)) < 50\n" +
            "ORDER BY total_actividades DESC;\n", nativeQuery = true)
    public List<String[]>  findMasActividadMenosReciclaje();


}

