package pe.edu.pe.grupo2.serviceimplements;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.Noticias;
import pe.edu.pe.grupo2.repositories.INoticiasRepository;
import pe.edu.pe.grupo2.serviceinterfaces.INoticiasService;

import java.util.List;

@Service
public class NoticiasServiceImplements implements INoticiasService {

    @Autowired
    private INoticiasRepository nR;

    @Override
    public List<Noticias> list() {
        return nR.findAll();
    }

    @Override
    public void insert(Noticias n) {
        nR.save(n);

    }

    @Override
    public void update(Noticias n) {
        nR.save(n);

    }

    @Override
    public void delete(int id) {
        nR.deleteById(id);

    }

    @Override
    public Noticias listId(int id) {
        return nR.findById(id).orElse(new Noticias());
    }

    @Override
    public List<Noticias> BuscarTitulo(String titulo) {
        return nR.BuscarTitulo(titulo);
    }
}
