package reposicion.lenguajes.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reposicion.lenguajes.Entities.Posicion;
import reposicion.lenguajes.Repositories.EquipoRepository;
import reposicion.lenguajes.Repositories.PosicionRepository;
import reposicion.lenguajes.Services.PosicionService;

@Service
public class PosicionServiceImpl implements PosicionService{

    @Autowired
    private PosicionRepository posicionRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public String simulacionPartidos() {
        if (this.equipoRepository.count() < 6) {
            return "Hay menos de 6 equipos, cree más\n";
        }else {
            return "simulacion hecha\n";
        }
    }

    @Override
    public List<Posicion> obtenerPosiciones() {
        return (List<Posicion>) this.posicionRepository.findAll();
    }
    
}
