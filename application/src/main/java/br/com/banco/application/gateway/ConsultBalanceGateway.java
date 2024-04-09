package br.com.banco.application.gateway;

import br.com.banco.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {

    BigDecimal consult(Wallet wallet);

}
