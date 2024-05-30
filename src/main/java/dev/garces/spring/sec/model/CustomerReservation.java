package dev.garces.spring.sec.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CustomerReservation")
public class CustomerReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer_reservation")
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    @Column(name = "reservation_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date reservationDate;

    @Column(name = "valor_reserva", nullable = false)
    private double valorReserva;
}
