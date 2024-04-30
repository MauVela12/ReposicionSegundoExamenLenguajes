package reposicion.lenguajes.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import reposicion.lenguajes.Entities.Equipo;

@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Integer>{
    
}
