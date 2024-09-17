package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.ActividadDTO;
import pe.edu.pe.grupo2.dtos.CloseToExpireDTO;
import pe.edu.pe.grupo2.dtos.MostClaimedRewardDTO;
import pe.edu.pe.grupo2.dtos.RecompensasDTO;
import pe.edu.pe.grupo2.entities.Recompensas;
import pe.edu.pe.grupo2.serviceinterfaces.IRecompensasService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recompensas")
@CrossOrigin(origins = "https://proud-radiance-production.up.railway.app")
@PreAuthorize("hasAuthority('ADMINISTRADOR')")
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

    @GetMapping("/{id}")
    public RecompensasDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        RecompensasDTO dto = m.map(vs.listId(id),RecompensasDTO.class);
        return dto;
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

    @GetMapping("/mas_reclamada")
    public List<MostClaimedRewardDTO> cantidad(){
        List<String[]> lista=vs.cantidadRecompensas();
        List<MostClaimedRewardDTO> listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            MostClaimedRewardDTO dto=new MostClaimedRewardDTO();
            dto.setRecompensa(columna[0]);
            dto.setCantidadreclamos(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/proxvencer")
    public List<CloseToExpireDTO> proxvencimiento(){
        List<String[]> lista=vs.proximoVencimiento();
        List<CloseToExpireDTO> listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            CloseToExpireDTO dto=new CloseToExpireDTO();
            dto.setRecompensa(columna[0]);
            dto.setProximovencer(LocalDate.parse(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
