package reposicion.lenguajes.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reposicion.lenguajes.Entities.Equipo;
import reposicion.lenguajes.Entities.Posicion;
import reposicion.lenguajes.Services.Impl.PosicionServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/posicion")
public class PosicionController {

    @Autowired
    private PosicionServiceImpl posicionServiceImpl;

    @PostMapping("/agregar")
    public String agregarEquipo(@RequestBody Equipo nvoEquipo) {
        return this.posicionServiceImpl.agregarEquipo(nvoEquipo);
    }

    @PostMapping("/simulando")
    public String sumularPartidos() {
        if (this.posicionServiceImpl.simulacionPartidos()) {
            return "Simulacion hecha\n";
        }else {
            return "Error en la simulacion\n";
        }
    }
    
    @GetMapping("/obtenerPosiciones")
    public List<Posicion> obtenerPosiciones() {
        return this.posicionServiceImpl.obtenerPosiciones();
    }

    @GetMapping("/campeon")
    public Equipo obtenerCampeon() {
        return this.posicionServiceImpl.obtenerCampeon();
    }
    
}
