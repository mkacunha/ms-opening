package br.com.gft.wa.opening.request;

import br.com.gft.wa.opening.domain.opening.OpeningPriority;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class UpdateOpeningRequest {

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

    @NotEmpty(message = "Deve ser informado ao menos um tipo de conhecimento")
    private List<String> knowledge;

    public String getName() {
        return name;
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

    public List<String> getKnowledge() {
        return knowledge;
    }
}
