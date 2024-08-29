package pe.edu.pe.grupo2.serviceimplements;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.Actividad;
import pe.edu.pe.grupo2.repositories.IActividadRepository;
import pe.edu.pe.grupo2.serviceinterfaces.IActividadService;

import java.util.List;

@Service
public class ActividadServiceImplement implements IActividadService {
    @Autowired
    private IActividadRepository cR;
    @Override
    public List<Actividad> list() {return cR.findAll();}
    @Override
    public void insert(Actividad a){cR.save(a);}

    @Override
    public Actividad listId(int id){return cR.findById(id).orElse(new Actividad());}

    @Override
    public void update(Actividad a){cR.save(a);}
    @Override
    public void delete(int id){cR.deleteById(id);}
    @Override
    public List<Actividad> buscarNombre(String nombre){ return cR.buscarNombre(nombre);}
}
