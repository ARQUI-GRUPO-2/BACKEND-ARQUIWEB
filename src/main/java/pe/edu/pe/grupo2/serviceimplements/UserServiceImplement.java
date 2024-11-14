package pe.edu.pe.grupo2.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.dtos.UserCentroReciclajeDTO;
import pe.edu.pe.grupo2.dtos.UserDTO;
import pe.edu.pe.grupo2.entities.User;
import pe.edu.pe.grupo2.repositories.UserRepository;
import pe.edu.pe.grupo2.serviceinterfaces.UserService;


import java.time.LocalDate;

import java.time.LocalTime;

import java.util.Collections;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository uR;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public List<User> list() {
        return uR.findAll();
    }

    @Override
    public void insert(User u) {
        String encryptedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encryptedPassword);
        uR.save(u);
    }

    @Override
    public User listId(int id) {
        return uR.findById(id).orElse(new User());
    }

    @Override
    public void update(User u) {
        // Verificar si la contraseña ha cambiado
        if (u.getPassword() != null) {
            String encryptedPassword = passwordEncoder.encode(u.getPassword());
            u.setPassword(encryptedPassword);
        }
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);

    }

    @Override
    public List<User> BuscarGenero(String genero) {
        return uR.BuscarGenero(genero);
    }

    @Override
    public List<String> obtenerUsuarioConCentrosDeReciclaje(int idUser) {
        return uR.obtenerUsuarioConCentrosDeReciclaje(idUser);
    }
    @Override
    public List<String> obtenerUsuarioConCentrosDeReciclajeFavorito(Boolean favoritos) {
        return uR.findUserWithCentrosReciclajeFiltered(favoritos);
    }

    @Override
    public List<String[]> Cantidadnotificaciones_deusuario_rangodias(LocalDate diaInicio, LocalDate diaFin) {
        return uR.Cantidadnotificaciones_deusuario_rangodias(diaInicio, diaFin);
    }

    /*@Override
    public List<User> getAllUsers() {
        return uR.findAll(); // Devuelve todos los usuarios de la base de datos
    }

    @Override
    public List<User> getUsersByUsername(String username) {
        // Busca el usuario por su username
        User user = uR.findByUsername(username);
        return user != null ? List.of(user) : List.of(); // Si el usuario existe, lo devuelve, si no, lista vacía
    }*/

}
