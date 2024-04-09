package br.com.banco.application.usecaseImpl;

import br.com.banco.application.gateway.FindWalletByTaxNumberGateway;
import br.com.banco.core.domain.Wallet;
import br.com.banco.core.exception.NotFoundException;
import br.com.banco.core.exception.enums.ErrorCodeEnum;
import br.com.banco.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {

    private FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet find(String taxNumber) throws NotFoundException {

        Wallet wallet = findWalletByTaxNumberGateway.find(taxNumber);
        if (wallet == null) {
            throw new NotFoundException(ErrorCodeEnum.WT0001.getMessage(), ErrorCodeEnum.WT0001.getCode());
        }
        return wallet;
    }
}
