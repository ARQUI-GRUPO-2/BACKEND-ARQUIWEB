package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.Banner;
import pe.edu.pe.grupo2.dtos.ActividadDTO;
import pe.edu.pe.grupo2.entities.Actividad;
import pe.edu.pe.grupo2.serviceinterfaces.IActividadService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actividad")
public class ActividadController {

    @Autowired
    private IActividadService cS;
    @GetMapping
    public List<ActividadDTO> listar() {

        return cS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ActividadDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody ActividadDTO dto) {
        ModelMapper m=new ModelMapper();
        Actividad ac = m.map(dto, Actividad.class);
        cS.insert(ac);
    }
    @GetMapping("/{id}")
    public ActividadDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        ActividadDTO dto = m.map(cS.listId(id),ActividadDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody ActividadDTO dto) {
        ModelMapper m = new ModelMapper();
        Actividad ac = m.map(dto, Actividad.class);
        cS.update(ac);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        cS.delete(id);
    }
    @GetMapping("/busquedas")
    public List<ActividadDTO> buscar(@RequestParam String nombre) {

        return cS.buscarNombre(nombre).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ActividadDTO.class);
        }).collect(Collectors.toList());
    }

}
