package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.TipoActividadDTO;
import pe.edu.pe.grupo2.entities.TipoActividad;
import pe.edu.pe.grupo2.serviceinterfaces.ITipoActividadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipodeactividades")
@CrossOrigin(origins = "https://proud-radiance-production.up.railway.app")
@PreAuthorize("hasAuthority('ADMINISTRADOR')")
public class TipoActividadController {
    @Autowired
    private ITipoActividadService tS;

    @GetMapping
    public List<TipoActividadDTO> listar() {
        return tS.list().stream().map(x -> {
            ModelMapper t = new ModelMapper();
            return t.map(x, TipoActividadDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody TipoActividadDTO dto) {
        ModelMapper t = new ModelMapper();
        TipoActividad ta = t.map(dto, TipoActividad.class);
        tS.insert(ta);
    }

    // Nuevo endpoint para obtener actividades que contienen un texto específico en la invitación
    @GetMapping("/buscarPorInvitacion")
    public List<TipoActividadDTO> buscarPorInvitacion(@RequestParam("texto") String texto) {
        return tS.findByInvitacionContaining(texto).stream().map(x -> {
            ModelMapper t = new ModelMapper();
            return t.map(x, TipoActividadDTO.class);
        }).collect(Collectors.toList());
    }

    // Nuevo endpoint para contar actividades con invitaciones no vacías
    @GetMapping("/contarInvitacionesNoVacias")
    public int contarInvitacionesNoVacias() {
        return tS.countNonEmptyInvitations();
    }
}
