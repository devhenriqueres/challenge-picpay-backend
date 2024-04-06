package br.com.banco.usecase;

import br.com.banco.core.domain.User;

public interface FindUserByTaxNumberUseCase {
    User find(String taxNumber);
}
