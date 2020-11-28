package br.com.gft.wa.manager.domain.wa;

public enum WaControlStatus {

    ALLOCATED(1, "Alocado", false, false),

    FUTURE_ALLOCATION(2, "Alocação Futura", false, false),

    NOT_PROPOSED(3, "Não Alocado", true, true),

    PROPOSED(4, "Proposto", true, true),

    RENEWING(5, "Em Renovação", true, false),

    RESERVED(6, "Reservado", true, false);

    public final int code;

    public final String description;

    public final boolean canPropose;

    public final boolean canReserve;

    WaControlStatus(int code, String description, boolean canPropose, boolean canReserve) {
        this.code = code;
        this.description = description;
        this.canPropose = canPropose;
        this.canReserve = canReserve;
    }
}
