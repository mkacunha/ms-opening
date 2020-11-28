package br.com.gft.wa.manager.domain.wa;

import br.com.gft.wa.manager.domain.employee.Employee;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_controle_oportunidade")
public class WaControlOpportunity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "projeto")
    private String project;

    @Column(name = "oportunidade")
    private String opportunity;

    @Column(name = "data_incl")
    private LocalDate date = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "id_controle")
    private WaControl control;

    @ManyToOne
    @JoinColumn(name = "id_fun")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_usu")
    private Employee user;

    protected WaControlOpportunity() {
    }

    public WaControlOpportunity(String project, String opportunity, WaControl control, Employee employee, Employee user) {
        this.project = project;
        this.opportunity = opportunity;
        this.control = control;
        this.employee = employee;
        this.user = user;
    }
}
