package com.laryon.api.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteRequest(

        @NotBlank(message = "el documento es obligatorio")
        @Size(max = 50, message = "el documento no puede superar 50 caracteres")
        String documento,

        @NotBlank(message = "el nombre es obligatorio")
        @Size(max = 150, message = "el nombre no puede superar 150 caracteres")
        String nombre,

        @Email(message = "el email no es valido")
        @Size(max = 150, message = "el email no puede superar 150 caracteres")
        String email,

        @Size(max = 30, message = "el telefono no puede superar 30 caracteres")
        String telefono
) {
}
