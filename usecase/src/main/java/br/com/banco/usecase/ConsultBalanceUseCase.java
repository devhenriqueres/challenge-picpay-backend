package br.com.banco.usecase;

import br.com.banco.core.domain.Wallet;
import br.com.banco.core.exception.ConsultBalanceException;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {
    BigDecimal consult(Wallet wallet) throws ConsultBalanceException;
}
