package br.com.gft.wa.opening.response;

import br.com.gft.wa.opening.domain.opening.Opening;
import br.com.gft.wa.opening.domain.opening.OpeningPriority;

import java.time.LocalDate;
import java.util.List;

public class OpeningResponse {

    private Long id;

    private String name;

    private LocalDate date;

    private LocalDate hiringDate;

    private OpeningPriority priority;

    private String activities;

    private String requirements;

    private String desirable;

    private String customer;

    private Long userId;

    private String userName;

    private List<String> knowledge;

    public OpeningResponse(Opening opening) {
        id = opening.getId();
        name = opening.getName();
        date = opening.getDate();
        hiringDate = opening.getHiringDate();
        priority = opening.getPriority();
        activities = opening.getActivities();
        requirements = opening.getRequirements();
        desirable = opening.getDesirable();
        customer = opening.getCustomer();
        userId = opening.getUser().getId();
        userName = opening.getUser().getName();
        knowledge = opening.getKnowledge();
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

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<String> getKnowledge() {
        return knowledge;
    }
}
