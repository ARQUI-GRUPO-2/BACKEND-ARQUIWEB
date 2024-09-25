package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.*;
import pe.edu.pe.grupo2.entities.CentroReciclaje;
import pe.edu.pe.grupo2.serviceinterfaces.ICentroReciclajeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/centros-de-reciclaje")
@CrossOrigin(origins = "https://proud-radiance-production.up.railway.app")
public class CentroReciclajeController {

    @Autowired
    private ICentroReciclajeService cS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public List<CentroReciclajeDTO> listarCentroReciclaje() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CentroReciclajeDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrarCentroReciclaje(@RequestBody CentroReciclajeDTO dto) {
        ModelMapper m = new ModelMapper();
        CentroReciclaje d = m.map(dto, CentroReciclaje.class);
        cS.insert(d);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminarCentroReciclaje(@PathVariable("id") Integer id) {
        cS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificarCentroReciclaje(@RequestBody CentroReciclajeDTO dto) {
        ModelMapper m = new ModelMapper();
        CentroReciclaje d = m.map(dto, CentroReciclaje.class);
        cS.update(d);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public CentroReciclajeDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        CentroReciclajeDTO dto = m.map(cS.listId(id), CentroReciclajeDTO.class);
        return dto;
    }

    @GetMapping("/actividades")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<ActividadCentroDTO> obtenerActividadesxCentroReciclaje() {
        List<String[]> lista = cS.actividadxnombreService();
        List<ActividadCentroDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            ActividadCentroDTO dto = new ActividadCentroDTO();
            dto.setNombre(columna[0]);
            dto.setDireccion(columna[1]);
            listaDTO.add(dto);

        }
        return listaDTO;
    }

    @GetMapping("/mas_actividad_menos_reciclado")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<MoreActivityLessRecyclingDTO> masActMenosRec() {
        List<String[]> lista = cS.masActividadMenosReciclaje();
        List<MoreActivityLessRecyclingDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            MoreActivityLessRecyclingDTO dto = new MoreActivityLessRecyclingDTO();
            dto.setDireccion(columna[0]);
            dto.setTotalActividades(Integer.parseInt(columna[1]));
            dto.setTotalReciclado(Double.parseDouble(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/mas_visitados")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<MostVisitedCentersDTO> centrosMasVisitados(@RequestParam(name = "direccion", required = false, defaultValue = "") String direccion) {
        List<String[]> lista = cS.masVisitasCentro(direccion);
        List<MostVisitedCentersDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            MostVisitedCentersDTO dto = new MostVisitedCentersDTO();
            dto.setDireccion(columna[0]);
            dto.setCantidadVisitas(Integer.parseInt(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
