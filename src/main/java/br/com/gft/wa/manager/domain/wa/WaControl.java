package br.com.gft.wa.manager.domain.wa;

import br.com.gft.wa.manager.domain.employee.Employee;
import br.com.gft.wa.manager.instrastructure.jpa.converter.WaControlStatusConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static br.com.gft.wa.manager.domain.wa.WaControlStatus.*;

@Entity
@Table(name = "tb_controle_wa")
public class WaControl {

    @Id
    @Column(name = "id_controle")
    private Long id;

    @Column(name = "status")
    @Convert(converter = WaControlStatusConverter.class)
    private WaControlStatus status;

    @ManyToOne
    @JoinColumn(name = "id_fun")
    private Employee employee;

    @OneToMany(mappedBy = "control", cascade = CascadeType.ALL)
    private List<WaControlOpportunity> opportunities = new ArrayList<>();

    @OneToMany(mappedBy = "control", cascade = CascadeType.ALL)
    private List<WaControlReservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "control", cascade = CascadeType.ALL)
    private List<WaControlHistory> histories = new ArrayList<>();

    public void propose(String project, String opportunity, Employee user) {
        if (!status.canPropose) {
            throw new RuntimeException("Funcionário " + employee.getName() + " não pode ser proposto, pois está " + status.description);
        }

        if (NOT_PROPOSED.equals(status)) {
            status = PROPOSED;
            this.histories.add(new WaControlHistory(this, status));
        }

        this.opportunities.add(new WaControlOpportunity(project, opportunity, this, employee, user));
    }

    public void reserve(String project, String reservation, Integer amountDays, Employee user) {
        if (!status.canPropose) {
            throw new RuntimeException("Funcionário " + employee.getName() + " não pode ser reservado, pois está " + status.description);
        }
        status = RESERVED;
        this.reservations.add(new WaControlReservation(project, reservation, amountDays, this, employee, user));
        this.histories.add(new WaControlHistory(this, status));
    }
}
