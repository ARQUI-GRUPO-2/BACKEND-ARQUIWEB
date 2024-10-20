package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.NotificacionesDTO;
import pe.edu.pe.grupo2.entities.Notificaciones;
import pe.edu.pe.grupo2.serviceinterfaces.INotificacionesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Notificaciones")
//@CrossOrigin(origins = "https://proud-radiance-production.up.railway.app")
public class NotificacionesController {
    @Autowired
    private INotificacionesService nR;

    @GetMapping
    //    @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public List<NotificacionesDTO> listar() {

        return nR.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionesDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    //   @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void insertar(@RequestBody NotificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones nt = m.map(dto, Notificaciones.class);
        nR.insert(nt);
    }
    @GetMapping("/{id}")
    //    @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public NotificacionesDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        NotificacionesDTO dto=m.map(nR.listId(id),NotificacionesDTO.class);
        return dto;
    }
    @PutMapping
    //    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody NotificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones ur = m.map(dto, Notificaciones.class);
        nR.update(ur);
    }
    @DeleteMapping("/{id}")
    //  @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id")Integer id) {
        nR.delete(id);
    }
}
