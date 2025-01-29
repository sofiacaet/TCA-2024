package com.example.models.enums;

public enum Status {
    DISPONIVEL_PRA_VENDA("disponivel para venda"),
    INDISPONIVEL("indisponivel"),
    RESERVADO("reservado");

    private final String descricao;

    // Construtor do Enum
    Status(String descricao) {
        this.descricao = descricao;
    }

    // Getter para a descrição
    public String getDescricao() {
        return descricao;
    }

    // Método estático para converter String em Status
    public static Status fromString(String value) {
        for (Status status : Status.values()) {
            if (status.getDescricao().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + value);
    }
}