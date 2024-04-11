package br.com.banco.usecase;

import br.com.banco.core.domain.TransactionPin;
import br.com.banco.core.exception.PinException;
import br.com.banco.core.exception.TransferException;

public interface TransactionPinValidateUseCase {
    Boolean validate(TransactionPin transactionPin) throws TransferException, PinException;
}
