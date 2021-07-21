package ar.com.ada.api.aladas.entities;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "vuelo")
public class Vuelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vuelo_id")
    private Integer vueloId;

    private Date fecha;

    @Column(name = "estado_vuelo_id")
    private Integer estadoVueloId;

    private Integer capacidad;

    @Column(name = "aeropuerto_origen")
    private Integer aeropuertoOrigen;

    @Column(name = "aeropuerto_destino")
    private Integer aeropuertoDestino;

    private BigDecimal precio;

    @Column(name = "codigo_moneda")
    private String codigoMoneda;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();

    //RB establecida entre vuelo y reserva
    public void agregarReserva(Reserva reserva){
        this.reservas.add(reserva);
        reserva.setVuelo(this);
    }

    
}
