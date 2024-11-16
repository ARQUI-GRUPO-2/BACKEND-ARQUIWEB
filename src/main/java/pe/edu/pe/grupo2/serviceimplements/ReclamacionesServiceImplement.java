package pe.edu.pe.grupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.Reclamaciones;
import pe.edu.pe.grupo2.repositories.IReclamacionesRepository;
import pe.edu.pe.grupo2.serviceinterfaces.IReclamacionesService;

import java.util.List;

@Service
public class ReclamacionesServiceImplement implements IReclamacionesService {
    @Autowired
    private IReclamacionesRepository rR;

    @Override
    public void insert(Reclamaciones reclamaciones) {
        rR.save(reclamaciones);
    }

    @Override
    public List<Reclamaciones> list() {
        return rR.findAll();
    }

    @Override
    public Reclamaciones listId(int idReclamaciones) {
        return rR.findById(idReclamaciones).orElse(new Reclamaciones());
    }

    @Override
    public void delete(int idReclamaciones) {
        rR.deleteById(idReclamaciones);
    }

    @Override
    public void update(Reclamaciones reclamaciones) {
        rR.save(reclamaciones);
    }
}
