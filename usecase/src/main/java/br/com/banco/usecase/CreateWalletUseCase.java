package br.com.banco.usecase;

import br.com.banco.core.domain.Wallet;

public interface CreateWalletUseCase {
    void create(Wallet wallet);
}
