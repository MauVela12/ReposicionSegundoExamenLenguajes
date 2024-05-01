package reposicion.lenguajes.Services;

import java.util.List;
import reposicion.lenguajes.Entities.Equipo;
import reposicion.lenguajes.Entities.Posicion;

public interface PosicionService {

    public String agregarEquipo(Equipo nvoEquipo);
    
    public boolean simulacionPartidos();

    public List<Posicion> obtenerPosiciones();

    public Equipo obtenerCampeon();
}
