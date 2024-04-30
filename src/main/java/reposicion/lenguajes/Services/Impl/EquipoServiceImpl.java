package reposicion.lenguajes.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reposicion.lenguajes.Entities.Equipo;
import reposicion.lenguajes.Repositories.EquipoRepository;
import reposicion.lenguajes.Services.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService{

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public String crearEquipo(Equipo nvoEquipo) {
        equipoRepository.save(nvoEquipo);
        return "Equipo agregado con exito\n";
    }

    @Override
    public String eliminarEquipo(int codigoEquipo) {
        Equipo resultado = this.equipoRepository.findById(codigoEquipo).get();
        if (resultado.getPosicion() != null) {
            return "El equipo ya tiene asignada una posicion\n";
        }else {
            this.equipoRepository.delete(resultado);
            return "Equipo eliminado con exito\n";
        }
    }

    @Override
    public Equipo obtenerEquipo(int codigoEquipo) {
        if (this.equipoRepository.existsById(codigoEquipo)) {
            return this.equipoRepository.findById(codigoEquipo).get();
        }else {
            return null;
        }
    }
    
}
