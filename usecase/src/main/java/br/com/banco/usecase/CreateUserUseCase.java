package br.com.banco.usecase;

import br.com.banco.core.domain.User;
import br.com.banco.core.exception.EmailException;
import br.com.banco.core.exception.InternalServerErrorException;
import br.com.banco.core.exception.TaxNumberException;
import br.com.banco.core.exception.TrasactionPinException;

public interface CreateUserUseCase {
    void create(User user, String pin) throws TaxNumberException, EmailException, TrasactionPinException, InternalServerErrorException;

}
