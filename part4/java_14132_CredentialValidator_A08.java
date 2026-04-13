import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.LoginException;
import javax.security.auth.UsernamePasswordLoginException;

public class java_14132_CredentialValidator_A08 implements CredentialValidator {

    private String username;
    private String password;

    public java_14132_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getCallerPrincipal() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void validate( javax.security.auth.Subject subject ) {
        // no-op
    }

    @Override
    public boolean validate( javax.security.auth.Subject subject, Object credentials ) {
        String suppliedCredential = (String) credentials;
        if (suppliedCredential == null) {
            throw new InvalidCredentialException("No credentials provided");
        }

        String[] credentialsArray = suppliedCredential.split(":");

        if (credentialsArray.length != 2) {
            throw new UsernamePasswordLoginException("Invalid username and password combination");
        }

        String suppliedUsername = credentialsArray[0];
        String suppliedPassword = credentialsArray[1];

        if (!suppliedUsername.equals(username) || !suppliedPassword.equals(password)) {
            throw new UsernamePasswordLoginException("Invalid username or password");
        }

        return true;
    }
}