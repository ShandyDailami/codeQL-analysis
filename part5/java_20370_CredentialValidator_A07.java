import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.*;
import javax.security.auth.spi.*;

public class java_20370_CredentialValidator_A07 implements CallbackHandler {

    private Subject subject;
    private String username;
    private String password;
    private boolean authenticated;

    public java_20370_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
        this.authenticated = false;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public boolean handle(Callback callback) throws java.io.IOException, javax.security.auth.AuthenticationException {
        if (!(callback instanceof UsernamePasswordCallback)) {
            return false;
        }

        UsernamePasswordCallback callbackImpl = (UsernamePasswordCallback) callback;
        callbackImpl.setRequestedPassword(this.password.toCharArray());

        if (this.username.equals(callbackImpl.getIdentifier()) && this.password.equals(callbackImpl.getPassword())) {
            this.authenticated = true;
            callbackImpl.setRequestedPassword(this.password.toCharArray());
            return true;
        } else {
            callbackImpl.reject("Unknown user or wrong password");
            return false;
        }
    }

    public void validate() throws java.io.IOException, javax.security.auth.AuthenticationException {
        if (!this.authenticated) {
            throw new javax.security.auth.AuthenticationException("User not authenticated.");
        }
    }

    public static void main(String[] args) {
        try {
            CustomCredentialValidator credentialValidator = new CustomCredentialValidator("username", "password");
            credentialValidator.validate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}