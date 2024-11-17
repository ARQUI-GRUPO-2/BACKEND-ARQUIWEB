package pe.edu.pe.grupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.pe.grupo2.entities.Favoritos;

public interface IFavoritosRepository extends JpaRepository<Favoritos, Integer> {

}
