package br.com.banco.usecase;

import br.com.banco.core.domain.Transaction;

public interface TransferUserCase {
    Boolean transfer(Transaction transaction);
}
