package br.com.gft.wa.manager.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProposeEmployeeRequest {

    @NotNull(message = "ID do controle é obrigatório")
    private Long waControlId;

    @NotNull(message = "Solicitante é obrigatório")
    private Long userId;

    @NotBlank(message = "Projeto é obrigatório")
    private String project;

    @NotBlank(message = "Oportunidade é obrigatório")
    private String opportunity;

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

    public String getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(String opportunity) {
        this.opportunity = opportunity;
    }
}
