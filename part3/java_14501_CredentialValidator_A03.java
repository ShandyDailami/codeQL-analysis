import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;

import java.security.AccessControlException;
import java.util.Arrays;

public class java_14501_CredentialValidator_A03 implements CredentialValidator {

    private String[] usernameToPassword = { "user1=password1", "user2=password2" };

    public java_14501_CredentialValidator_A03() {
    }

    @Override
    public Subject getSubject(CallbackHandler callbackHandler,
            Callback[] callbacks) throws AuthenticationException,
            AccessControlException {
        throw new UnsupportedCallbackException(
                callbackHandler, "Unsupported callback");
    }

    @Override
    public String getName() {
        return "Custom Credential Validator";
    }

    @Override
    public String[] getAcceptedPasswordTypes() {
        return new String[] { "password" };
    }

    @Override
    public boolean validate(String inputPassword) throws AuthenticationException {
        for (String passwordInfo : usernameToPassword) {
            String[] userCredentials = passwordInfo.split("=");
            if (userCredentials[0].equals(inputPassword)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidationRequest request = new CredentialValidationRequest();
        request.setUsername("username");
        request.setPassword("password");
        CustomCredentialValidator credentialValidator = new CustomCredentialValidator();
        request.setCredentialValidator(credentialValidator);

        try {
            request.perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}