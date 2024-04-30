package reposicion.lenguajes.Services;

import reposicion.lenguajes.Entities.Equipo;

public interface EquipoService {
    
    public String crearEquipo(Equipo nvoEquipo);

    public String eliminarEquipo(int codigoEquipo);

    public Equipo obtenerEquipo(int codigoEquipo);
}
