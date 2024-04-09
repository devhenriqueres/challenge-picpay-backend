package br.com.banco.application.gateway;

import br.com.banco.core.domain.TransactionPin;
import br.com.banco.core.domain.User;
import br.com.banco.core.domain.Wallet;

public interface CreateUserGateway {
    Boolean create(User user, Wallet wallet, TransactionPin transactionPin);
}
