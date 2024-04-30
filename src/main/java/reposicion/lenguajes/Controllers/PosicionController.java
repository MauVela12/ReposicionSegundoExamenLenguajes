package reposicion.lenguajes.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reposicion.lenguajes.Entities.Posicion;
import reposicion.lenguajes.Services.Impl.PosicionServiceImpl;

@RestController
@RequestMapping("/api/posicion")
public class PosicionController {

    @Autowired
    private PosicionServiceImpl posicionServiceImpl;

    @PostMapping("/simulando")
    public String sumularPartidos() {
        return this.posicionServiceImpl.simulacionPartidos();
    }
    
    @PutMapping("/obtenerPosiciones")
    public List<Posicion> obtenerPosiciones() {
        return this.posicionServiceImpl.obtenerPosiciones();
    }
}
