package br.com.banco.usecase;

import br.com.banco.core.domain.Transaction;
import br.com.banco.core.exception.TransferException;
import br.com.banco.core.exception.TrasactionException;

public interface CreateTransactionUseCase {
    Transaction create(Transaction transaction) throws TransferException, TrasactionException;
}
