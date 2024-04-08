package br.com.banco.application.gateway;

public interface EmailAvailableGateway {
    Boolean available(String email);
}
