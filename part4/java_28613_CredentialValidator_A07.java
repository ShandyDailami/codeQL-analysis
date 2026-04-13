import java.security.AuthFailureException;
import java.security.Credential;
import java.security.GeneralSecurityException;

public class java_28613_CredentialValidator_A07 implements javax.security.auth.login.CredentialValidator {

    @Override
    public Credential validate(Credential c) throws AuthFailureException, GeneralSecurityException {
        String userName = c.getUsername();
        String password = new String(c.getPassword());

        // Here, you can implement your own logic to validate the username and password.
        // For example, you might check if the username is "admin" and the password is "password".

        if ("admin".equals(userName) && "password".equals(password)) {
            return c;
        } else {
            throw new AuthFailureException("Invalid username or password");
        }
    }
}