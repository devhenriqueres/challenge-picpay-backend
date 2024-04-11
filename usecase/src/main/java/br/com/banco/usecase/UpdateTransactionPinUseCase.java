package br.com.banco.usecase;

import br.com.banco.core.domain.TransactionPin;

public interface UpdateTransactionPinUseCase {
    TransactionPin update(TransactionPin transactionPin);
}
