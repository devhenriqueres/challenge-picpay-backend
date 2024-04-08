package br.com.banco.application.usecaseImpl;

import br.com.banco.application.gateway.TaxNumberAvailableGateway;
import br.com.banco.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {

    private TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public Boolean available(String taxNumber) {
        return taxNumberAvailableGateway.available(taxNumber);
    }
}
