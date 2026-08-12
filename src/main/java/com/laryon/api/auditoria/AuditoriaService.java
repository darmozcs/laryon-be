package com.laryon.api.auditoria;

import com.laryon.api.cliente.ClienteRepository;
import com.laryon.api.common.ClienteNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditoriaService {

    private final AuditoriaRepository auditoriaRepository;
    private final ClienteRepository clienteRepository;

    AuditoriaService(AuditoriaRepository auditoriaRepository, ClienteRepository clienteRepository) {
        this.auditoriaRepository = auditoriaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public AuditoriaResponse registrar(AuditoriaRequest request) {
        if (!clienteRepository.existsById(request.clienteId())) {
            throw new ClienteNotFoundException(request.clienteId());
        }

        Auditoria auditoria = new Auditoria();
        auditoria.setClienteId(request.clienteId());
        auditoria.setMacAddress(request.macAddress());

        return AuditoriaResponse.from(auditoriaRepository.save(auditoria));
    }
}
