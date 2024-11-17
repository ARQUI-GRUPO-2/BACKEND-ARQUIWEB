package pe.edu.pe.grupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.Actividad;
import pe.edu.pe.grupo2.repositories.IActividadRepository;
import pe.edu.pe.grupo2.serviceinterfaces.IActividadService;

import java.util.List;

@Service
public class ActividadServiceImplement implements IActividadService {

    @Autowired
    private IActividadRepository aR;

    @Override
    public List<Actividad> list() {return aR.findAll();}
    @Override
    public void insert(Actividad a){
        aR.save(a);}

    @Override
    public Actividad listId(int id){return aR.findById(id).orElse(new Actividad());}

    @Override
    public void update(Actividad a){
        aR.save(a);}
    @Override
    public void delete(int id){
        aR.deleteById(id);}


    @Override
    public List<String[]> ActividadesporCentro() {
        return aR.ActividadesporCentro();
    }

    @Override
    public List<String[]> ActividadesporUsuario() {
        return aR.ActividadesporUsuario();
    }
}
