package com.laryon.api.cliente;

import java.time.Instant;

public record ClienteResponse(
        Long id,
        String documento,
        String nombre,
        String email,
        String telefono,
        boolean activo,
        Instant createdAt,
        Instant updatedAt
) {

    public static ClienteResponse from(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getDocumento(),
                cliente.getNombre(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.isActivo(),
                cliente.getCreatedAt(),
                cliente.getUpdatedAt()
        );
    }
}
