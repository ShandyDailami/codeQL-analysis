import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_27660_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public String validate(jav.security.auth.Credential cred) throws LoginException {
        String user = cred.getIdentifier();
        String password = cred.getPassword();

        // For simplicity, let's assume that the passwords are always correct.
        // In real applications, you'd typically want to use a stronger mechanism
        // for checking passwords and throw exceptions when the password is not correct.
        if ("user".equals(user) && "password".equals(password)) {
            return null; // indicates successful validation
        } else {
            throw new LoginException("Invalid credentials"); // indicates failure
        }
    }

    @Override
    public boolean requiresUsername() {
        return false;
    }

    @Override
    public boolean requiresPassword() {
        return true;
    }
}