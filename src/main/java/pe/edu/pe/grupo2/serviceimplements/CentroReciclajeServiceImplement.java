package pe.edu.pe.grupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.CentroReciclaje;
import pe.edu.pe.grupo2.repositories.ICentroReciclajeRepository;
import pe.edu.pe.grupo2.serviceinterfaces.ICentroReciclajeService;

import java.util.List;

@Service
public class CentroReciclajeServiceImplement implements ICentroReciclajeService {

    @Autowired
    private ICentroReciclajeRepository cR;

    @Override
    public List<CentroReciclaje> list() { return cR.findAll();}
}
