CREATE TABLE lay_cliente (
    id BIGSERIAL PRIMARY KEY,
    documento VARCHAR(50) NOT NULL,
    nombre VARCHAR(150) NOT NULL,
    email VARCHAR(150),
    telefono VARCHAR(30),
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    CONSTRAINT uq_lay_cliente_documento UNIQUE (documento)
);
