package br.com.gft.wa.opening.response;

import br.com.gft.wa.opening.domain.opening.Opening;
import br.com.gft.wa.opening.domain.opening.OpeningPriority;

import java.time.LocalDate;

public class OpeningSummaryResponse {

    private Long id;

    private String name;

    private LocalDate date;

    private LocalDate hiringDate;

    private OpeningPriority priority;

    private String userName;

    public OpeningSummaryResponse(Opening opening) {
        id = opening.getId();
        name = opening.getName();
        date = opening.getDate();
        hiringDate = opening.getHiringDate();
        priority = opening.getPriority();
        userName = opening.getUser().getName();
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

    public String getUserName() {
        return userName;
    }
}
