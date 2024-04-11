package br.com.banco.application.usecaseImpl;

import br.com.banco.application.gateway.TransferGateway;
import br.com.banco.core.domain.Transaction;
import br.com.banco.core.domain.Wallet;
import br.com.banco.core.exception.*;
import br.com.banco.core.exception.enums.ErrorCodeEnum;
import br.com.banco.usecase.*;

import java.math.BigDecimal;

public class TransferUserCaseImpl implements TransferUserCase {

    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private UserNotificationUseCase userNotificationUseCase;

    private TransferGateway transferGateway;
    private TransactionPinValidateUseCase transactionPinValidateUseCase;

    public TransferUserCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, UserNotificationUseCase userNotificationUseCase, TransferGateway transferGateway, TransactionPinValidateUseCase transactionPinValidateUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transferGateway = transferGateway;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
    }

    @Override
    public Boolean transfer(String toTaxNumber, String fromTaxNumber, BigDecimal value, String pin) throws TransferException, InternalServerErrorException, NotFoundException, NotificationException, TrasactionException, PinException {
        Wallet from = findWalletByTaxNumberUseCase.find(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.find(toTaxNumber);

        transactionPinValidateUseCase.validate(from.getTransactionPin());

        Transaction transaction = createTransactionUseCase.create(new Transaction(from, to, value));

        transactionValidateUseCase.validate(transaction);

        from.transfer(value);
        to.receiveTransfer(value);

        if (!transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        if (!userNotificationUseCase.notificate(transaction, to.getUser().getEmail())) {
            throw new NotificationException(ErrorCodeEnum.NF0001.getMessage(), ErrorCodeEnum.NF0001.getCode());
        }

        return true;
    }
}
