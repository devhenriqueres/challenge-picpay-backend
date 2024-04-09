package br.com.banco.application.usecaseImpl;

import br.com.banco.application.gateway.TransactionValidateGateway;
import br.com.banco.core.domain.Transaction;
import br.com.banco.core.exception.TransferException;
import br.com.banco.core.exception.enums.ErrorCodeEnum;
import br.com.banco.usecase.TransactionValidateUseCase;

public class TransactionValidateUseCaseImpl implements TransactionValidateUseCase {

    private TransactionValidateGateway transactionValidateGateway;

    public TransactionValidateUseCaseImpl(TransactionValidateGateway transactionValidateGateway) {
        this.transactionValidateGateway = transactionValidateGateway;
    }

    @Override
    public Boolean validate(Transaction transaction) throws TransferException {
        Boolean isValidated = transactionValidateGateway.validate(transaction);

        if (!isValidated) {
            throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }

        return true;
    }
}
