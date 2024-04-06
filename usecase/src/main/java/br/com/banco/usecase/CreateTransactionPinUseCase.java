package br.com.banco.usecase;

import br.com.banco.core.domain.TransactionPin;

public interface CreateTransactionPinUseCase {
    void create(TransactionPin transactionPin);
}
