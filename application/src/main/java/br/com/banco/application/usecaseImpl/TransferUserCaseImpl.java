package br.com.banco.application.usecaseImpl;

import br.com.banco.application.gateway.TransferGateway;
import br.com.banco.core.domain.Transaction;
import br.com.banco.core.domain.Wallet;
import br.com.banco.core.exception.InternalServerErrorException;
import br.com.banco.core.exception.NotFoundException;
import br.com.banco.core.exception.NotificationException;
import br.com.banco.core.exception.TransferException;
import br.com.banco.core.exception.enums.ErrorCodeEnum;
import br.com.banco.usecase.*;

import java.math.BigDecimal;

public class TransferUserCaseImpl implements TransferUserCase {

    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private UserNotificationUseCase userNotificationUseCase;

    private TransferGateway transferGateway;

    public TransferUserCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, UserNotificationUseCase userNotificationUseCase, TransferGateway transferGateway) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transferGateway = transferGateway;
    }

    @Override
    public Boolean transfer(String toTaxNumber, String fromTaxNumber, BigDecimal value) throws TransferException, InternalServerErrorException, NotFoundException, NotificationException {
        Wallet from = findWalletByTaxNumberUseCase.find(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.find(toTaxNumber);

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
