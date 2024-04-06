package br.com.banco.usecase;

import br.com.banco.core.domain.Transaction;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction);
}
