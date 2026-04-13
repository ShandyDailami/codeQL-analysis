import javax.naming.AuthenticationException;
import javax.security.auth.login.LoginException;

public class java_33580_CredentialValidator_A01 {

    public void validate(String userName, String password) throws LoginException, AuthenticationException {

        // In a real-world scenario, this method would take
        // place in a more complex authentication system,
        // handling multiple user records, validating passwords,
        // and ensuring sensitive operations are performed

        // For the sake of simplicity, let's assume if the credentials are valid,
        // they are returned immediately. If not, the system throws an exception.

        if (isValid(userName, password)) {
            return;
        }

        throw new AuthenticationException("Invalid credentials");
    }

    private boolean isValid(String userName, String password) {
        // This is a simple comparison. In a real-world scenario,
        // you would compare passwords in a more secure way.

        // For the sake of simplicity, let's assume valid users have a valid password.
        return password.equals("valid_password");
    }
}