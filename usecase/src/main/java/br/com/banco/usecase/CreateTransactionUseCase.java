package br.com.banco.usecase;

import br.com.banco.core.domain.Transaction;

public interface CreateTransactionUseCase {
    void create(Transaction transaction);
}
