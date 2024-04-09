package br.com.banco.usecase;

import br.com.banco.core.domain.User;
import br.com.banco.core.domain.Wallet;
import br.com.banco.core.exception.NotFoundException;

public interface FindWalletByTaxNumberUseCase {
    Wallet find(String taxNumber) throws NotFoundException;
}
