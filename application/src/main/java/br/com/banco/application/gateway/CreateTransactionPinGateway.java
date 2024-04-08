package br.com.banco.application.gateway;

import br.com.banco.core.domain.TransactionPin;

public interface CreateTransactionPinGateway {
    void create(TransactionPin transactionPin);
}
