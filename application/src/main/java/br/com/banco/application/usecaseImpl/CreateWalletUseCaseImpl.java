package br.com.banco.application.usecaseImpl;

import br.com.banco.application.gateway.CreateWalletGateway;
import br.com.banco.core.domain.Wallet;
import br.com.banco.usecase.CreateWalletUseCase;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {

    private CreateWalletGateway createWalletGateway;

    public CreateWalletUseCaseImpl(CreateWalletGateway createWalletGateway) {
        this.createWalletGateway = createWalletGateway;
    }

    @Override
    public void create(Wallet wallet) {
        createWalletGateway.create(wallet);
    }
}
