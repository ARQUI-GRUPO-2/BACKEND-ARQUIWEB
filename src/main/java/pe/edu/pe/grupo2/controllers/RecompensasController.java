package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.RecompensasDTO;
import pe.edu.pe.grupo2.entities.Recompensas;
import pe.edu.pe.grupo2.serviceinterfaces.IRecompensasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recompensas")
public class RecompensasController {
    @Autowired
    private
    IRecompensasService vs;

    @PostMapping
    public void registrar(@RequestBody RecompensasDTO dto) {
        ModelMapper m = new ModelMapper();
        Recompensas d = m.map(dto, Recompensas.class);
        vs.insert(d);
    }

    @GetMapping
    public List<RecompensasDTO> listar() {
        return vs.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,RecompensasDTO.class);
        }).collect(Collectors.toList());
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        vs.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody RecompensasDTO dto) {
        ModelMapper m = new ModelMapper();
        Recompensas d = m.map(dto, Recompensas.class);
        vs.update(d);
    }
}
