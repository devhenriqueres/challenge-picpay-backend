package br.com.banco.application.usecaseImpl;

import br.com.banco.application.gateway.TransactionPinValidateGateway;
import br.com.banco.core.domain.TransactionPin;
import br.com.banco.core.exception.PinException;
import br.com.banco.core.exception.enums.ErrorCodeEnum;
import br.com.banco.usecase.TransactionPinValidateUseCase;
import br.com.banco.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {

    private TransactionPinValidateGateway transactionPinValidateGateway;
    private UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway, UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) throws PinException {
        if (transactionPin.getBlocked()) throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());

        if (!transactionPinValidateGateway.validate(transactionPin)) {
            transactionPin.setAttempt();
            TransactionPin transactionPinUpdated = updateTransactionPinUseCase.update(transactionPin);
            throw new PinException(ErrorCodeEnum.pinGetMessage(transactionPinUpdated.getAttempt()), ErrorCodeEnum.PIN0002.getCode());
        }

        if (transactionPin.getAttempt() < 3){
            transactionPin.resetAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }

        return true;
    }
}
