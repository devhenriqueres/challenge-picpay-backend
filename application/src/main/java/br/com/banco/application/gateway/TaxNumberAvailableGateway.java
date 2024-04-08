package br.com.banco.application.gateway;

import br.com.banco.core.domain.TaxNumber;

public interface TaxNumberAvailableGateway {
    Boolean available(String taxNumber);
}
