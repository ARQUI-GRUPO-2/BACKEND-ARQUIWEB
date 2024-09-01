package pe.edu.pe.grupo2.serviceinterfaces;

import pe.edu.pe.grupo2.entities.User;
import java.util.List;

public interface UserService {

    public List<User> list();
    public void insert(User u);
    public User listId(int id);
    public void update(User u);
    public void delete(int id);
    public List<User> BuscarGenero(String genero);

}
