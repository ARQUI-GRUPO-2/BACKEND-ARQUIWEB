package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.pe.grupo2.dtos.UserCentroReciclajeDTO;
import pe.edu.pe.grupo2.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findOneByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from User u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

    @Query("select ur from User ur where ur.genero like %:genero%")
    public List<User> BuscarGenero(@Param("genero") String Genero);

    @Query("SELECT u.nombres, u.edad, cr.direccion, cr.horario " +
            "FROM User u " +
            "JOIN CentroReciclaje cr ON cr.us.idUser = u.idUser " +
            "WHERE u.idUser = :idUser")
    List<UserCentroReciclajeDTO> obtenerUsuarioConCentrosDeReciclaje(@Param("idUser") Integer idUser);

}
