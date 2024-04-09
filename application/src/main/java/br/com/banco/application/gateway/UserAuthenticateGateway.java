package br.com.banco.application.gateway;

public interface UserAuthenticateGateway {
    Boolean authenticate(String username, String password);
}
