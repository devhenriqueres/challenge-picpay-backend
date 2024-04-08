package br.com.banco.application.gateway;

import br.com.banco.core.domain.User;

public interface CreateUserGateway {
    User create(User user);
}
