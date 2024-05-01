package reposicion.lenguajes.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reposicion.lenguajes.Entities.Equipo;
import reposicion.lenguajes.Services.Impl.EquipoServiceImpl;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {
    
    @Autowired
    private EquipoServiceImpl  equipoServiceImpl;

    @DeleteMapping("/eliminar/{codigoEquipo}")
    public String eliminarEquipo(@PathVariable int codigoEquipo){
        return this.equipoServiceImpl.eliminarEquipo(codigoEquipo);
    }

    @GetMapping("/buscarPorId/{codigoEquipo}")
    public Equipo buscarPorId(@PathVariable int codigoEquipo) {
        return this.equipoServiceImpl.obtenerEquipo(codigoEquipo);
    }

}
