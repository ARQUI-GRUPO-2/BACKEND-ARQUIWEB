package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.tipo_actividadDTO;
import pe.edu.pe.grupo2.serviceinterfaces.tipo_actividadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/centros-de-reciclaje")
public class tipo_actividadController {

    @Autowired
    private tipo_actividadService tA;
    @GetMapping
    public List<tipo_actividadDTO> listar() {

        return tA.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, tipo_actividadDTO.class);
        }).collect(Collectors.toList());
        @PostMapping
        public void insertar(@RequestBody VehicleDTO dto) {
            ModelMapper m = new ModelMapper();
            Vehicle ve = m.map(dto, Vehicle.class);
            tA.insert(ve);

        }
    }
}
