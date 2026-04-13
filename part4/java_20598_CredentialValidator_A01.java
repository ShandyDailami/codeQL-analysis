import javax.security.auth.CredentialException;
import javax.security.auth.PasswordAuthentication;
import javax.security.auth.login.LoginException;

public class java_20598_CredentialValidator_A01 implements javax.security.auth.login.CredentialValidator {

    // Authenticate method
    @Override
    public PasswordAuthentication validate(PasswordAuthentication password) throws CredentialException {
        String user = password.getUsername();
        String passwordStr = new String(password.getPassword());

        // Validate user and password
        if (user.equals("admin") && passwordStr.equals("password")) {
            return password;
        } else {
            throw new CredentialException("Invalid username or password");
        }
    }
}