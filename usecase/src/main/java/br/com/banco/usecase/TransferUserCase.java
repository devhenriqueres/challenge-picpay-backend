package br.com.banco.usecase;

import br.com.banco.core.domain.Transaction;
import br.com.banco.core.exception.InternalServerErrorException;
import br.com.banco.core.exception.NotFoundException;
import br.com.banco.core.exception.NotificationException;
import br.com.banco.core.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUserCase {
    Boolean transfer(String toTaxNumber, String fromTaxNumber, BigDecimal value) throws TransferException, InternalServerErrorException, NotFoundException, NotificationException;
}
