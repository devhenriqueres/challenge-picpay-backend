package br.com.banco.application.usecaseImpl;

import br.com.banco.application.gateway.UserNotificationGateway;
import br.com.banco.core.domain.Transaction;
import br.com.banco.usecase.UserNotificationUseCase;

public class UserNotificationImpl implements UserNotificationUseCase {

    private UserNotificationGateway userNotificationGateway;

    public UserNotificationImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return userNotificationGateway.notificate(transaction, email);
    }
}
