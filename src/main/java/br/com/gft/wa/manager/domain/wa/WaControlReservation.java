package br.com.gft.wa.manager.domain.wa;

import br.com.gft.wa.manager.domain.employee.Employee;

import javax.persistence.*;

@Entity
@Table(name = "tb_controle_reserva")
public class WaControlReservation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "projeto")
    private String project;

    @Column(name = "reserva")
    private String reservation;

    @Column(name = "qtd_de_dias")
    private Integer amountDays;

    @ManyToOne
    @JoinColumn(name = "id_controle")
    private WaControl control;

    @ManyToOne
    @JoinColumn(name = "id_fun")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_usu")
    private Employee user;

    protected WaControlReservation() {
    }

    public WaControlReservation(String project, String reservation, Integer amountDays, WaControl control, Employee employee, Employee user) {
        this.project = project;
        this.reservation = reservation;
        this.control = control;
        this.employee = employee;
        this.user = user;
        this.amountDays = amountDays;
    }
}
