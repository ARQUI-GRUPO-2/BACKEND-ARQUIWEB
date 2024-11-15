package pe.edu.pe.grupo2.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.CantidadNotiUsuarioDTO;
import pe.edu.pe.grupo2.dtos.UserCentroReciclajeDTO;
import pe.edu.pe.grupo2.dtos.UserDTO;
import pe.edu.pe.grupo2.entities.User;
import pe.edu.pe.grupo2.repositories.UserRepository;
import pe.edu.pe.grupo2.serviceinterfaces.UserService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
//@CrossOrigin(origins = "https://proud-radiance-production.up.railway.app")
public class UserController {
    @Autowired
    private UserService uS;
    @Autowired
    private UserRepository uR;

    @PostMapping
    //  @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public void insertar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        User ur = m.map(dto, User.class);
        uS.insert(ur);
    }

   @GetMapping
    //   @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<UserDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }


   /* @GetMapping
        public List<UserDTO> listar(@AuthenticationPrincipal User currentUser) {
            ModelMapper m = new ModelMapper();

            // Verificar el rol del usuario
            if ("ADMI".equals(currentUser.getRol().getNombreRol())) {
                // Si es admin, listar todos los usuarios
                return uS.list().stream().map(x -> m.map(x, UserDTO.class)).collect(Collectors.toList());
            } else if ("CLIENTE".equals(currentUser.getRol().getNombreRol())) {
                // Si es cliente, listar solo su propio usuario
                return List.of(m.map(currentUser, UserDTO.class));
            }

            // Si el rol no es válido, retornar lista vacía
            return List.of();
        }*/

    @GetMapping("/{id}")
    //   @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public UserDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        UserDTO dto = m.map(uS.listId(id), UserDTO.class);
        return dto;
    }

    @PutMapping
    //  @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public void modificar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        User ur = m.map(dto, User.class);
        uS.update(ur);
    }

    @DeleteMapping("/{id}")
    //  @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id) {
        uS.delete(id);
    }

    @GetMapping("/busquedas")
    //  @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<UserDTO> buscar(@RequestParam String genero) {

        return uS.BuscarGenero(genero).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }


    @GetMapping("/conteo_notificaciones_rangodias")
    //   @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<CantidadNotiUsuarioDTO> Cantidadnotificaciones_deusuario_rangodias(@RequestParam LocalDate diaInicio, @RequestParam LocalDate diaFin) {
        List<String[]> filaLista = uS.Cantidadnotificaciones_deusuario_rangodias(diaInicio, diaFin);
        List<CantidadNotiUsuarioDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            CantidadNotiUsuarioDTO dto = new CantidadNotiUsuarioDTO();
            dto.setNombres(columna[0]);
            dto.setCantidad_notif(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}



