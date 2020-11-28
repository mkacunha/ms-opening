package br.com.gft.wa.manager.domain.feedback;

import br.com.gft.wa.manager.domain.employee.Employee;
import br.com.gft.wa.manager.instrastructure.jpa.converter.BooleanConverter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_feedback_wa")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feed")
    private Long id;

    @Column(name = "projeto")
    private String project;

    @Column(name = "motivo")
    private String reason;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "data_aviso")
    private LocalDate date;

    @Column(name = "data_entrada")
    private LocalDate waDate;

    @Column(name = "funcionario_avisado")
    @Convert(converter = BooleanConverter.class)
    private boolean warnedEmployee;

    @Column(name = "renovacao")
    @Convert(converter = BooleanConverter.class)
    private boolean renewing;

    @ManyToOne
    @JoinColumn(name = "id_fun")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_usu")
    private Employee manager;

    protected Feedback() {
    }

    public Feedback(String project, String reason, String feedback, boolean warnedEmployee, boolean renewing, Employee employee, Employee manager) {
        this.project = project;
        this.reason = reason;
        this.feedback = feedback;
        this.warnedEmployee = warnedEmployee;
        this.renewing = renewing;
        this.employee = employee;
        this.manager = manager;
        this.date = LocalDate.now();
        this.waDate = this.date.plusDays(15);
    }
}
