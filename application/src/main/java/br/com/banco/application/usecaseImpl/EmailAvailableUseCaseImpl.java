package br.com.banco.application.usecaseImpl;

import br.com.banco.application.gateway.EmailAvailableGateway;
import br.com.banco.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {

    private EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean available(String email) {
        return emailAvailableGateway.available(email);
    }
}
