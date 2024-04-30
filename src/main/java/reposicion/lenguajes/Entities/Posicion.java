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
}
