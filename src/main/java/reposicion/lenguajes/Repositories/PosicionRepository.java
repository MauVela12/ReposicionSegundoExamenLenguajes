package reposicion.lenguajes.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import reposicion.lenguajes.Entities.Posicion;

@Repository
public interface PosicionRepository extends CrudRepository<Posicion, Integer>{
    
}
