package reposicion.lenguajes.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "posiciones")
public class Posicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idposicion")
    private int idposicion;
    
    private int empates;

    private int ganados;

    private int perdidos;

    @Column(name = "golesfavor")
    private int golesfavor;

    @Column(name = "golescontra")
    private int golescontra;

    private int puntos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigoequipo", referencedColumnName = "codigoequipo")
    private Equipo equipo;

    public void acumularPartidosGanados() {
        this.ganados += 1; 
    }

    public void acumularPartidosPerdidos() {
        this.perdidos += 1; 
    }

    public void acumularPartidosEmpatados() {
        this.empates += 1; 
    }

    public void acumularGolesFavor(int golesFavor) {
        this.golesfavor += golesFavor; 
    }

    public void acumularGolesContra(int golesContra) {
        this.golescontra += golesContra; 
    }

    public void acumularPuntos(boolean resultado) {
        if (resultado) {
            this.puntos += 3; 
        }else {
            if (!resultado) {
                this.puntos += 1;
            }
        }
    }

}
