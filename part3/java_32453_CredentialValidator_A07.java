import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.CallerNotIDPException;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_32453_CredentialValidator_A07 {
    public CredentialValidationResult validate(Credential credential) throws LoginException, CallerNotIDPException, UnsupportedCallbackException {
        String password = credential.getPassword();

        // Throw an exception if the password is not "password"
        if (!password.equals("password")) {
            throw new LoginException("Invalid password");
        }

        // Return a successful result if the password is correct
        return new CredentialValidationResult("Authenticated", null, null);
    }
}