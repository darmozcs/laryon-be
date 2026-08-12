package com.laryon.api.auditoria;

import java.time.Instant;

public record AuditoriaResponse(
        Long id,
        Long clienteId,
        String macAddress,
        Instant fechaHora
) {

    public static AuditoriaResponse from(Auditoria auditoria) {
        return new AuditoriaResponse(
                auditoria.getId(),
                auditoria.getClienteId(),
                auditoria.getMacAddress(),
                auditoria.getFechaHora()
        );
    }
}
