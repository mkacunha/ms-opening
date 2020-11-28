package br.com.gft.wa.manager.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SendFeedbackRequest {

    @NotNull(message = "Funcionário é obrigatório")
    private Long employeeId;

    @NotNull(message = "Gestor é obrigatório")
    private Long managerId;

    @NotBlank(message = "Motivo é obrigatório")
    private String reason;

    @NotBlank(message = "Projeto é obrigatório")
    private String project;

    @NotBlank(message = "Feedback é obrigatório")
    private String feedback;

    private boolean warnedEmployee;

    private boolean renewing;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public boolean isWarnedEmployee() {
        return warnedEmployee;
    }

    public void setWarnedEmployee(boolean warnedEmployee) {
        this.warnedEmployee = warnedEmployee;
    }

    public boolean isRenewing() {
        return renewing;
    }

    public void setRenewing(boolean renewing) {
        this.renewing = renewing;
    }
}
