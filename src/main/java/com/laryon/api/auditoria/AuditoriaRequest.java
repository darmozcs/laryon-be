package com.laryon.api.auditoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AuditoriaRequest(

        @NotNull(message = "el clienteId es obligatorio")
        Long clienteId,

        @NotBlank(message = "la mac es obligatoria")
        @Pattern(
                regexp = "^([0-9A-Fa-f]{2}:){5}[0-9A-Fa-f]{2}$",
                message = "la mac debe tener el formato AA:BB:CC:DD:EE:FF"
        )
        String macAddress
) {
}
