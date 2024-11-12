package pe.edu.pe.grupo2.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.NoticiasDTO;
import pe.edu.pe.grupo2.entities.Noticias;
import pe.edu.pe.grupo2.serviceinterfaces.INoticiasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/noticias")
//@CrossOrigin(origins = "https://proud-radiance-production.up.railway.app")
public class NoticiaController {
    @Autowired
    private INoticiasService nR;

    @GetMapping
    //   @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public List<NoticiasDTO> listar() {

        return nR.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NoticiasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    //   @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void insertar(@RequestBody NoticiasDTO dto) {
        ModelMapper m = new ModelMapper();
        Noticias ur = m.map(dto, Noticias.class);
        nR.insert(ur);
    }
    @GetMapping("/{id}")
    //    @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public NoticiasDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        NoticiasDTO dto=m.map(nR.listId(id),NoticiasDTO.class);
        return dto;
    }
    @PutMapping
    //   @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody NoticiasDTO dto) {
        ModelMapper m = new ModelMapper();
        Noticias ur = m.map(dto, Noticias.class);
        nR.update(ur);
    }
    @DeleteMapping("/{id}")
    //    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id")Integer id) {
        nR.delete(id);
    }

    @GetMapping("/busqueda de Noticia")
    //  @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<NoticiasDTO> buscar(@RequestParam String titulo) {

        return nR.BuscarTitulo(titulo).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NoticiasDTO.class);
        }).collect(Collectors.toList());
    }

}
