package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.pe.grupo2.entities.Recompensas;

import java.util.List;

public interface IRecompensasRepository extends JpaRepository<Recompensas, Integer> {

    //@Query(value = "", nativeQuery = true)
    //public List<String[]> cantidadMantenimientos();
}
