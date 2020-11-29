package br.com.gft.wa.opening.domain.opening;

import br.com.gft.wa.opening.domain.employee.Employee;
import br.com.gft.wa.opening.instrastructure.jpa.converter.OpeningPriorityConverter;
import br.com.gft.wa.opening.request.UpdateOpeningRequest;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_vagas")
public class Opening {

    @Id
    @Column(name = "id_vaga")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_vaga")
    private String name;

    @Column(name = "data_incl")
    private LocalDate date = LocalDate.now();

    @Column(name = "data_vaga")
    private LocalDate hiringDate;

    @Column(name = "prioridade")
    @Convert(converter = OpeningPriorityConverter.class)
    private OpeningPriority priority;

    @Column(name = "atividades")
    private String activities;

    @Column(name = "requisitos")
    private String requirements;

    @Column(name = "desejaveis")
    private String desirable;

    @Column(name = "cliente")
    private String customer;

    @ManyToOne
    @JoinColumn(name = "id_usu")
    public Employee user;

    @ElementCollection
    @CollectionTable(name = "tb_vagas_conhecimento", joinColumns = @JoinColumn(name = "id_vaga"))
    @Column(name = "conhecimento")
    public List<String> knowledge;

    protected Opening() {
    }

    public Opening(
            String name,
            LocalDate hiringDate,
            OpeningPriority priority,
            String activities,
            String requirements,
            String desirable,
            String customer,
            Employee user,
            List<String> knowledge
    ) {
        this.name = name;
        this.hiringDate = hiringDate;
        this.priority = priority;
        this.activities = activities;
        this.requirements = requirements;
        this.desirable = desirable;
        this.customer = customer;
        this.user = user;
        this.knowledge = knowledge;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public OpeningPriority getPriority() {
        return priority;
    }

    public String getActivities() {
        return activities;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getDesirable() {
        return desirable;
    }

    public String getCustomer() {
        return customer;
    }

    public Employee getUser() {
        return user;
    }

    public List<String> getKnowledge() {
        return knowledge;
    }

    public void update(UpdateOpeningRequest request) {
        this.name = request.getName();
        this.hiringDate = request.getHiringDate();
        this.priority = request.getPriority();
        this.activities = request.getActivities();
        this.requirements = request.getRequirements();
        this.desirable = request.getDesirable();
        this.customer = request.getCustomer();
        this.knowledge = request.getKnowledge();
    }
}
