package ar.com.ada.api.aladas.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "pasajero")
public class Pasajero extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pasajero_id")
    private Integer pasajeroId;

    @OneToMany(mappedBy = "pasajero", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<Reserva> reservas = new ArrayList<>();


    @OneToOne(mappedBy = "pasajero", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;

    
    public Integer getPasajeroId(){
        return pasajeroId;
    }

    public void setPasajeroId(Integer pasajeroId){
        this.pasajeroId = pasajeroId;
    }

    public List<Reserva> getReservas(){
        return reservas;
    }

    public void setReservas(List<Reserva> reservas){
        this.reservas = reservas;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
        usuario.setPasajero(this); //RB establecida entre pasajero y usuario 
    }

    //RB con reserva
    public void agregarReserva(Reserva reserva){
        this.reservas.add(reserva);
        reserva.setPasajero(this); //en algun momento tengo que llamar a este metodo sino no se establecera la RB
    }

    
    
}
