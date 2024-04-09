package br.com.banco.application.gateway;

import br.com.banco.core.domain.Transaction;

public interface TransactionValidateGateway {
    Boolean validate(Transaction transaction);
}
