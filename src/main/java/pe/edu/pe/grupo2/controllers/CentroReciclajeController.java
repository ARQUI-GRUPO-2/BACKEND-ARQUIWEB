package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.ActividadCentroDTO;
import pe.edu.pe.grupo2.dtos.CentroReciclajeDTO;
import pe.edu.pe.grupo2.entities.CentroReciclaje;
import pe.edu.pe.grupo2.serviceinterfaces.ICentroReciclajeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/centros-de-reciclaje")
public class CentroReciclajeController {

    @Autowired
    private ICentroReciclajeService cS;

    @PostMapping
    public void registrarCentroReciclaje(@RequestBody CentroReciclajeDTO dto) {
        ModelMapper m = new ModelMapper();
        CentroReciclaje d = m.map(dto, CentroReciclaje.class);
        cS.insert(d);
    }

    @GetMapping
    public List<CentroReciclajeDTO> listarCentroReciclaje() {
        return cS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, CentroReciclajeDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminarCentroReciclaje(@PathVariable("id") Integer id) {
        cS.delete(id);
    }

    @PutMapping
    public void modificarCentroReciclaje(@RequestBody CentroReciclajeDTO dto) {
        ModelMapper m = new ModelMapper();
        CentroReciclaje d = m.map(dto, CentroReciclaje.class);
        cS.update(d);
    }
    @GetMapping("/actividades")
    public List<ActividadCentroDTO> obtenerActividadesxCentroReciclaje() {
        List<String[]> lista= cS.actividadxnombreService();
        List<ActividadCentroDTO> listaDTO=new ArrayList<>();
        for (String[] columna:lista){
            ActividadCentroDTO dto=new ActividadCentroDTO();
            dto.setNombre(columna[0]);
            dto.setDireccion(columna[1]);
            listaDTO.add(dto);

        }
        return listaDTO;
    }
}
