package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.ActividadDTO;
import pe.edu.pe.grupo2.dtos.ActividadRecompensasDTO;
import pe.edu.pe.grupo2.dtos.ActividadesPorCentroDTO;
import pe.edu.pe.grupo2.dtos.ActividadesPorUsuarioDTO;
import pe.edu.pe.grupo2.entities.Actividad;
import pe.edu.pe.grupo2.serviceinterfaces.IActividadService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actividad")
//@CrossOrigin(origins = "https://proud-radiance-production.up.railway.app")

public class ActividadController {

    @Autowired
    private IActividadService aS;
     @GetMapping
    //   @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public List<ActividadDTO> listar() {

        return aS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ActividadDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    //  @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public void insertar(@RequestBody ActividadDTO dto) {
        ModelMapper m=new ModelMapper();
        Actividad ac = m.map(dto, Actividad.class);
        aS.insert(ac);
    }

    @GetMapping("/{id}")
    //   @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public ActividadDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        ActividadDTO dto = m.map(aS.listId(id),ActividadDTO.class);
        return dto;
    }

    @PutMapping
    //  @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public void update(@RequestBody ActividadDTO dto) {
        ModelMapper m = new ModelMapper();
        Actividad ac = m.map(dto, Actividad.class);
        aS.update(ac);
    }

    @DeleteMapping("/{id}")
    //   @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id) {
        aS.delete(id);
    }

    @GetMapping("/busquedas")
    //   @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<ActividadDTO> buscar(@RequestParam String nombre) {

        return aS.buscarNombre(nombre).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ActividadDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/recompensas")
    //  @PreAuthorize("hasAuthority('ADMINISTRADOR')")
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
    @GetMapping("/ActividadesPorCentro")
    //    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<ActividadesPorCentroDTO> actividadesPorCentro(){
        List<String[]> lista = aS.ActividadesporCentro();
        List<ActividadesPorCentroDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            ActividadesPorCentroDTO dto = new ActividadesPorCentroDTO();
            dto.setId_centro_reciclaje(Integer.parseInt(columna[0]));
            dto.setNumero_actividades(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/ActividadesPorUsuario")
    //    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<ActividadesPorUsuarioDTO> actividadesPorUsuario(){
        List<String[]> lista = aS.ActividadesporUsuario();
        List<ActividadesPorUsuarioDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            ActividadesPorUsuarioDTO dto = new ActividadesPorUsuarioDTO();
            dto.setId_user(Integer.parseInt(columna[0]));
            dto.setNumeroactividades(Integer.parseInt(columna[1]));
            dto.setTotal_puntos(Integer.parseInt(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}