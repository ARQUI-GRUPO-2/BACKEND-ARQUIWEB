package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.Banner;
import pe.edu.pe.grupo2.dtos.ActividadCentroDTO;
import pe.edu.pe.grupo2.dtos.ActividadDTO;
import pe.edu.pe.grupo2.dtos.ActividadRecompensasDTO;
import pe.edu.pe.grupo2.entities.Actividad;
import pe.edu.pe.grupo2.serviceinterfaces.IActividadService;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actividad")
public class ActividadController {

    @Autowired
    private IActividadService aS;
    @GetMapping
    public List<ActividadDTO> listar() {

        return aS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ActividadDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ActividadDTO dto) {
        ModelMapper m=new ModelMapper();
        Actividad ac = m.map(dto, Actividad.class);
        aS.insert(ac);
    }

    @GetMapping("/{id}")
    public ActividadDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        ActividadDTO dto = m.map(aS.listId(id),ActividadDTO.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody ActividadDTO dto) {
        ModelMapper m = new ModelMapper();
        Actividad ac = m.map(dto, Actividad.class);
        aS.update(ac);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        aS.delete(id);
    }

    @GetMapping("/busquedas")
    public List<ActividadDTO> buscar(@RequestParam String nombre) {

        return aS.buscarNombre(nombre).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ActividadDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/recompensas")
    public List<ActividadRecompensasDTO> obtenerpuntosxactividad(){
        List<String[]> lista = aS.puntosxactividadService();
        List<ActividadRecompensasDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            ActividadRecompensasDTO dto = new ActividadRecompensasDTO();
            dto.setNombre(columna[0]);
            dto.setPuntos(columna[1]);
            dto.setNombre_recompensa(columna[2]);
            listaDTO.add(dto);

        }
        return listaDTO;
    }

}
