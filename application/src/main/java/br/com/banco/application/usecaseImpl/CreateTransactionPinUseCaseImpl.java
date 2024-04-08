package br.com.banco.application.usecaseImpl;

import br.com.banco.application.gateway.CreateTransactionPinGateway;
import br.com.banco.core.domain.TransactionPin;
import br.com.banco.usecase.CreateTransactionPinUseCase;

public class CreateTransactionPinUseCaseImpl implements CreateTransactionPinUseCase {

    private CreateTransactionPinGateway createTransactionPinGateway;

    public CreateTransactionPinUseCaseImpl(CreateTransactionPinGateway createTransactionPinGateway) {
        this.createTransactionPinGateway = createTransactionPinGateway;
    }

    @Override
    public void create(TransactionPin transactionPin) {
        createTransactionPinGateway.create(transactionPin);
    }
}
