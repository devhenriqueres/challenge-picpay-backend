package br.com.banco.usecase;

import br.com.banco.core.exception.*;

import java.math.BigDecimal;

public interface TransferUserCase {
    Boolean transfer(String toTaxNumber, String fromTaxNumber, BigDecimal value, String pin) throws TransferException, InternalServerErrorException, NotFoundException, NotificationException, TrasactionException, PinException;
}
