package pe.edu.pe.grupo2.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.NoticiasDTO;
import pe.edu.pe.grupo2.entities.Noticias;
import pe.edu.pe.grupo2.serviceinterfaces.INoticiasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Noticias")
@CrossOrigin(origins = "https://proud-radiance-production.up.railway.app")
@PreAuthorize("hasAuthority('ADMINISTRADOR')")
public class NoticiaController {
    @Autowired
    private INoticiasService nR;

    @GetMapping
    public List<NoticiasDTO> listar() {

        return nR.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NoticiasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody NoticiasDTO dto) {
        ModelMapper m = new ModelMapper();
        Noticias ur = m.map(dto, Noticias.class);
        nR.insert(ur);
    }
    @GetMapping("/{id}")
    public NoticiasDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        NoticiasDTO dto=m.map(nR.listId(id),NoticiasDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody NoticiasDTO dto) {
        ModelMapper m = new ModelMapper();
        Noticias ur = m.map(dto, Noticias.class);
        nR.update(ur);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id) {
        nR.delete(id);
    }

    @GetMapping("/busqueda de Noticia")
    public List<NoticiasDTO> buscar(@RequestParam String titulo) {

        return nR.BuscarTitulo(titulo).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NoticiasDTO.class);
        }).collect(Collectors.toList());
    }
    
}
