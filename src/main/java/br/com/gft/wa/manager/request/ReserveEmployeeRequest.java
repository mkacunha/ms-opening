package br.com.gft.wa.manager.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReserveEmployeeRequest {

    @NotNull(message = "ID do controle é obrigatório")
    private Long waControlId;

    @NotNull(message = "Solicitante é obrigatório")
    private Long userId;

    @NotBlank(message = "Projeto é obrigatório")
    private String project;

    @NotBlank(message = "Reserva é obrigatório")
    private String reservation;

    @NotNull(message = "Quantidade de dias é obrigatório")
    private Integer amountDays;

    public Long getWaControlId() {
        return waControlId;
    }

    public void setWaControlId(Long waControlId) {
        this.waControlId = waControlId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public Integer getAmountDays() {
        return amountDays;
    }

    public void setAmountDays(Integer amountDays) {
        this.amountDays = amountDays;
    }
}
