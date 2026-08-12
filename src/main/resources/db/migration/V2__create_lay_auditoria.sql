CREATE TABLE lay_auditoria (
    id BIGSERIAL PRIMARY KEY,
    cliente_id BIGINT NOT NULL REFERENCES lay_cliente (id),
    mac_address VARCHAR(17) NOT NULL,
    fecha_hora TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_lay_auditoria_cliente_id ON lay_auditoria (cliente_id);
CREATE INDEX idx_lay_auditoria_mac_address ON lay_auditoria (mac_address);
