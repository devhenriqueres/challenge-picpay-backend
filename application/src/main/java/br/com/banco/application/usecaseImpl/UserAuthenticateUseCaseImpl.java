package br.com.banco.application.usecaseImpl;

import br.com.banco.application.gateway.UserAuthenticateGateway;
import br.com.banco.core.exception.AuthenticateException;
import br.com.banco.core.exception.enums.ErrorCodeEnum;
import br.com.banco.usecase.UserAuthenticateUseCase;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {

    private UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username, String password) throws AuthenticateException {

        Boolean isAuth = userAuthenticateGateway.authenticate(username, password);

        if (!isAuth) {
            throw new AuthenticateException(ErrorCodeEnum.AUTH0001.getMessage(), ErrorCodeEnum.AUTH0001.getCode());
        }

        return true;

    }
}
