package br.com.banco.application.usecaseImpl;

import br.com.banco.application.gateway.CreateTransactionGateway;
import br.com.banco.core.domain.Transaction;
import br.com.banco.core.exception.TransferException;
import br.com.banco.core.exception.TrasactionException;
import br.com.banco.core.exception.enums.ErrorCodeEnum;
import br.com.banco.usecase.CreateTransactionUseCase;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    private CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction transaction) throws TransferException, TrasactionException {

        Transaction transactionSaved = createTransactionGateway.create(transaction);

        if (transactionSaved == null) {
            throw new TrasactionException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        return transactionSaved;
    }
}
