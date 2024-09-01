package pe.edu.pe.grupo2.serviceimplements;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.User;
import pe.edu.pe.grupo2.repositories.UserRepository;
import pe.edu.pe.grupo2.serviceinterfaces.UserService;


import java.util.List;
@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository uS;

    @Override
    public List<User> list() {
        return uS.findAll();
    }

    @Override
    public void insert(User u) {
        uS.save(u);

    }

    @Override
    public User listId(int id) {
        return uS.findById(id).orElse(new User());
    }

    @Override
    public void update(User u) {
        uS.save(u);
    }

    @Override
    public void delete(int id) {
        uS.deleteById(id);

    }

    @Override
    public List<User> BuscarGenero(String genero) {
        return uS.BuscarGenero(genero);
    }
}
