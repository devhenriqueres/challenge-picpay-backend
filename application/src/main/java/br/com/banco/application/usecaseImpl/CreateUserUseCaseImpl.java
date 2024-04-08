package br.com.banco.application.usecaseImpl;

import br.com.banco.application.gateway.CreateUserGateway;
import br.com.banco.core.domain.TransactionPin;
import br.com.banco.core.domain.User;
import br.com.banco.core.domain.Wallet;
import br.com.banco.core.exception.EmailException;
import br.com.banco.core.exception.TaxNumberException;
import br.com.banco.core.exception.TrasactionPinException;
import br.com.banco.core.exception.enums.ErrorCodeEnum;
import br.com.banco.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private EmailAvailableUseCase emailAvailableUseCase;
    private CreateUserGateway createUserGateway;

    private CreateWalletUseCase createWalletUseCase;
    private CreateTransactionPinUseCase createTransactionPinUseCase;

    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway, CreateTransactionPinUseCase createTransactionPinUseCase) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
        this.createTransactionPinUseCase = createTransactionPinUseCase;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, EmailException, TrasactionPinException {

        if (!taxNumberAvailableUseCase.available(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getCode(), ErrorCodeEnum.ON0002.getMessage());
        }

        if (!emailAvailableUseCase.available(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getCode(), ErrorCodeEnum.ON0003.getMessage());
        }

        User userSaved = createUserGateway.create(user);

        createWalletUseCase.create(new Wallet(BigDecimal.ZERO, userSaved));
        createTransactionPinUseCase.create(new TransactionPin(userSaved, pin));

    }


}
