package br.com.gft.wa.opening.request;

import br.com.gft.wa.opening.domain.opening.OpeningPriority;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class NewOpeningRequest {

    @NotBlank(message = "Nome da vaga é obrigatório")
    private String name;

    @NotNull(message = "Data para contratação é obrigatório")
    private LocalDate hiringDate;

    @NotNull(message = "Prioridade é obrigatório")
    private OpeningPriority priority;

    @NotBlank(message = "Atividades é obrigatório")
    private String activities;

    @NotBlank(message = "Requisitos é obrigatório")
    private String requirements;

    @NotBlank(message = "Conhecimentos desejáveis é obrigatório")
    private String desirable;

    @NotBlank(message = "Cliente é obrigatório")
    private String customer;

    @NotNull(message = "Solicitante é obrigatório")
    public Long userId;

    @NotEmpty(message = "Deve ser informado ao menos um tipo de conhecimento")
    private List<String> knowledge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public OpeningPriority getPriority() {
        return priority;
    }

    public void setPriority(OpeningPriority priority) {
        this.priority = priority;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDesirable() {
        return desirable;
    }

    public void setDesirable(String desirable) {
        this.desirable = desirable;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(List<String> knowledge) {
        this.knowledge = knowledge;
    }
}
