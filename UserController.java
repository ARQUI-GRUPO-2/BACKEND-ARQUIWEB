package pe.edu.pe.grupo2.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.UserDTO;
import pe.edu.pe.grupo2.entities.User;
import pe.edu.pe.grupo2.serviceinterfaces.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Usuarios")
public class UserController {
    @Autowired
    private UserService uS;

    @GetMapping
    public List<UserDTO> listar() {

        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        User ur = m.map(dto, User.class);
        uS.insert(ur);
    }
    @GetMapping("/{id}")
    public UserDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        UserDTO dto=m.map(uS.listId(id),UserDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        User ur = m.map(dto, User.class);
        uS.update(ur);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id) {
        uS.delete(id);
    }

    @GetMapping("/busquedas")
    public List<UserDTO> buscar(@RequestParam String genero) {

        return uS.BuscarGenero(genero).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }
}
