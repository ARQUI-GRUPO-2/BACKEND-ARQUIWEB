package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.RolDTO;
import pe.edu.pe.grupo2.entities.Rol;
import pe.edu.pe.grupo2.serviceinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
@PreAuthorize("hasAuthority('ADMINISTRADOR')")
public class RolController {

    @Autowired
    private IRolService rS;

    @PostMapping
    public void registrarRol (@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol d = m.map(dto, Rol.class);
        rS.insert(d);
    }

    @GetMapping
    public List<RolDTO> listarRol() {
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable("id") Integer id) {
        rS.delete(id);
    }

    @PutMapping
    public void modificarRol(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol d = m.map(dto, Rol.class);
        rS.update(d);
    }

    @GetMapping("/{id}")
    public RolDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        RolDTO dto=m.map(rS.listId(id),RolDTO.class);
        return dto;
    }
}
