package br.com.gft.wa.manager.domain.wa;

import br.com.gft.wa.manager.instrastructure.jpa.converter.WaControlStatusConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_controle_wa_hist")
public class WaControlHistory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_controle")
    private WaControl control;

    @Column(name = "data_status")
    private LocalDateTime date = LocalDateTime.now();

    @Column(name = "status")
    @Convert(converter = WaControlStatusConverter.class)
    private WaControlStatus status;

    public WaControlHistory(WaControl control, WaControlStatus status) {
        this.control = control;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public WaControl getControl() {
        return control;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public WaControlStatus getStatus() {
        return status;
    }
}
