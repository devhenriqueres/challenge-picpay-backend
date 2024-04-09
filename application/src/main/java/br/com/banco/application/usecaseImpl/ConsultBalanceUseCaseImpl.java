package br.com.banco.application.usecaseImpl;

import br.com.banco.application.gateway.ConsultBalanceGateway;
import br.com.banco.core.domain.Wallet;
import br.com.banco.core.exception.ConsultBalanceException;
import br.com.banco.core.exception.enums.ErrorCodeEnum;
import br.com.banco.usecase.ConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {

    private ConsultBalanceGateway consultBalanceGateway;

    public ConsultBalanceUseCaseImpl(ConsultBalanceGateway consultBalanceGateway) {
        this.consultBalanceGateway = consultBalanceGateway;
    }

    @Override
    public BigDecimal consult(Wallet wallet) throws ConsultBalanceException {

        BigDecimal balance = consultBalanceGateway.consult(wallet);

        if (balance == null) {
            throw new ConsultBalanceException(ErrorCodeEnum.CB0001.getMessage(), ErrorCodeEnum.CB0001.getCode());
        }

        return balance;

    }
}
