package pe.edu.pe.grupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.tipo_actividad;
import pe.edu.pe.grupo2.repositories.tipo_actividadRepository;
import pe.edu.pe.grupo2.serviceinterfaces.tipo_actividadService;

import java.util.List;

@Service
public class tipo_actividadServicelment implements tipo_actividadservice {

    @Autowired
    private tipo_actividadRepository tA;

    @Override
    public List<tipo_actividad> list() { return tA.findAll();}
}
