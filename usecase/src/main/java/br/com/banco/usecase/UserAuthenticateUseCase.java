package br.com.banco.usecase;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String username, String password);
}
