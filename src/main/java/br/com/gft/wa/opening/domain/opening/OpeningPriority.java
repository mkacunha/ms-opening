package br.com.gft.wa.opening.domain.opening;

public enum OpeningPriority {
    CLOSED(0, "Encerrado"), HIGH(1, "Alto"), MEDIUM(2, "Médio"), LOW(3, "Baixo");

    public final int code;

    private final String description;

    OpeningPriority(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
