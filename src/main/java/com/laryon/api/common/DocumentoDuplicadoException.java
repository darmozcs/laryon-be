package com.laryon.api.common;

public class DocumentoDuplicadoException extends RuntimeException {

    public DocumentoDuplicadoException(String documento) {
        super("Ya existe un cliente con documento " + documento);
    }
}
