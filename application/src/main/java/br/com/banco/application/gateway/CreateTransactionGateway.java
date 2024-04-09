package br.com.banco.application.gateway;

import br.com.banco.core.domain.Transaction;

public interface CreateTransactionGateway {
    Transaction create(Transaction transaction);
}
