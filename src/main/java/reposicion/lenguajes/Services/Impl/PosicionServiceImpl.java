package reposicion.lenguajes.Services.Impl;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reposicion.lenguajes.Entities.Equipo;
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

    private void restartPosiciones() {
        List<Posicion> posiciones = (List<Posicion>) this.posicionRepository.findAll();

        for (Posicion posicion : posiciones) {
            posicion.setEmpates(0);
            posicion.setGanados(0);
            posicion.setGolescontra(0);
            posicion.setGolesfavor(0);
            posicion.setPerdidos(0);
            posicion.setPuntos(0);

            this.posicionRepository.save(posicion);
        }
    }

    @Override
    public String agregarEquipo(Equipo nvoEquipo) {

        Posicion nvaPosicion = new Posicion();
        nvaPosicion.setEquipo(nvoEquipo);
        
        this.posicionRepository.save(nvaPosicion);
        return "Equipo agregado con exito\n";
    }

    @Override
    public boolean simulacionPartidos() {

        restartPosiciones();
         
        if (this.equipoRepository.count() < 6) {
            return false;
        }else {
            List<Posicion> posiciones = (List<Posicion>) this.posicionRepository.findAll();

            Random rand = new Random();

            int contador = 1;
            
            do{
                for(int i = 0; i <= posiciones.size(); i++) {
                    for(int j = i + 1; j < posiciones.size(); j++) {
    
                        int golesEquipo1 = rand.nextInt(7);
                        int golesEquipo2 = rand.nextInt(7);
    
                        posiciones.get(i).acumularGolesFavor(golesEquipo1);
                        posiciones.get(j).acumularGolesFavor(golesEquipo2);
    
                        posiciones.get(i).acumularGolesContra(golesEquipo2);
                        posiciones.get(j).acumularGolesContra(golesEquipo1);
    
    
                        if (golesEquipo1 > golesEquipo2) {
                            posiciones.get(i).acumularPuntos(true);
                            posiciones.get(i).acumularPartidosGanados();
                            posiciones.get(j).acumularPartidosPerdidos();
                        }else {
                            if (golesEquipo2 > golesEquipo1) {
                                posiciones.get(j).acumularPuntos(true);
                                posiciones.get(j).acumularPartidosGanados();
                                posiciones.get(i).acumularPartidosPerdidos();
                            }else {
                                posiciones.get(i).acumularPuntos(false);
                                posiciones.get(j).acumularPuntos(false);
                                posiciones.get(i).acumularPartidosEmpatados();
                                posiciones.get(j).acumularPartidosEmpatados();
                            }
                        }
                        this.posicionRepository.save(posiciones.get(i));
                        this.posicionRepository.save(posiciones.get(j));
                    }
                }

                contador++;

            }while(contador == 2);

            return true;
        }
    }

    @Override
    public List<Posicion> obtenerPosiciones() {
        return (List<Posicion>) this.posicionRepository.findAll();
    }

    @Override
    public Equipo obtenerCampeon() {

        List<Posicion> posiciones = (List<Posicion>) this.posicionRepository.findAll();

        Equipo campeon = posiciones.get(0).getEquipo();

        int mayor = posiciones.get(0).getPuntos();

        for (int i = 1; i < posiciones.size(); i++) {
            if (posiciones.get(i).getPuntos() > mayor) {
                campeon = posiciones.get(i).getEquipo();
            }
        }

        return campeon;
    }
    
}
