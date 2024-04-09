package br.com.banco.usecase;

import br.com.banco.core.domain.Transaction;
import br.com.banco.core.exception.TransferException;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction) throws TransferException;
}
