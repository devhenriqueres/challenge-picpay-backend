package br.com.banco.application.gateway;

import br.com.banco.core.domain.Transaction;

public interface UserNotificationGateway {
    Boolean notificate(Transaction transaction, String email);
}
