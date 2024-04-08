package br.com.banco.application.gateway;

import br.com.banco.core.domain.Wallet;

public interface CreateWalletGateway {
    void create(Wallet wallet);
}
