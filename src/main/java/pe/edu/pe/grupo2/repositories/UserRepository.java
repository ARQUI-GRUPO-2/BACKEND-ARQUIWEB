package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.pe.grupo2.dtos.UserCentroReciclajeDTO;
import pe.edu.pe.grupo2.entities.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findOneByUsername(String username);

    //public User findByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from User u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);


    //INSERTAR ROLES
    //@Transactional
    //@Modifying
    //@Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    //public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);
    //@Query(value = "insert into roles (rol, idRol) VALUES (:rol, :user_id)", nativeQuery = true)
    //public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

    @Query("select ur from User ur where ur.distrito like %:distrito%")
    public List<User> BuscarDistrito(@Param("distrito") String Distrito);

    @Query("SELECT u.nombres, u.edad, cr.direccion, cr.horario " +
            "FROM User u " +
            "JOIN CentroReciclaje cr ON cr.us.idUser = u.idUser " +
            "WHERE u.idUser = :idUser")
    public List<String> obtenerUsuarioConCentrosDeReciclaje(@Param("idUser") Integer idUser);

    @Query("SELECT u.nombres, u.edad, cr.direccion, cr.horario " +
            "FROM User u " +
            "JOIN CentroReciclaje cr ON cr.us.idUser = u.idUser " +
            "WHERE cr.favoritos = :favoritos")
    public List<String> findUserWithCentrosReciclajeFiltered(@Param("favoritos") Boolean favoritos);

    //Cantidad de Notificaciones de un usuario en un rango de dias
    @Query(value = "SELECT us.nombres, COUNT(*) AS cantidad_notif " +
            "FROM notificaciones AS noti " +
            "INNER JOIN usuario AS us ON noti.id_user = us.id_user " +
            "WHERE noti.fecha_notificacion BETWEEN :diaInicio AND :diaFin " +
            "GROUP BY us.nombres",
            nativeQuery = true)
    public List<String[]> Cantidadnotificaciones_deusuario_rangodias(@Param("diaInicio") LocalDate diaInicio, @Param("diaFin") LocalDate diaFin);

    @Query(value = "SELECT us.distrito, COUNT(*) AS cantidad_usuarios " +
                "FROM usuario AS us " +
                "GROUP BY us.distrito " +
                "ORDER BY cantidad_usuarios DESC",
                nativeQuery = true)
    public List<String[]> ObtenerCantidadUsuariosPorDistrito();
}
