package com.laryon.api.cliente;

import com.laryon.api.common.ClienteNotFoundException;
import com.laryon.api.common.DocumentoDuplicadoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteResponse create(ClienteRequest request) {
        if (clienteRepository.existsByDocumento(request.documento())) {
            throw new DocumentoDuplicadoException(request.documento());
        }

        Cliente cliente = new Cliente();
        aplicarDatos(cliente, request);

        return ClienteResponse.from(clienteRepository.save(cliente));
    }

    @Transactional
    public ClienteResponse update(Long id, ClienteRequest request) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));

        if (clienteRepository.existsByDocumentoAndIdNot(request.documento(), id)) {
            throw new DocumentoDuplicadoException(request.documento());
        }

        aplicarDatos(cliente, request);

        return ClienteResponse.from(clienteRepository.save(cliente));
    }

    @Transactional(readOnly = true)
    public ClienteResponse getById(Long id) {
        return clienteRepository.findById(id)
                .map(ClienteResponse::from)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    private void aplicarDatos(Cliente cliente, ClienteRequest request) {
        cliente.setDocumento(request.documento());
        cliente.setNombre(request.nombre());
        cliente.setEmail(request.email());
        cliente.setTelefono(request.telefono());
    }
}
