import javax.naming.AuthenticationException;
import javax.security.auth.Subject;
import javax.security.auth.password.PasswordChangeAllowedException;
import javax.security.auth.password.PasswordState;
import javax.security.auth.password.UnsupportedPasswordException;
import java.security.auth.password.PasswordAuthentication;

public class java_10063_CredentialValidator_A08 implements PasswordAuthentication {

    private String username;

    public java_10063_CredentialValidator_A08(String username) {
        this.username = username;
    }

    @Override
    public String getCallerPrincipal() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.username;
    }

    @Override
    public Subject getSubject() {
        return null;
    }

    @Override
    public void clearPassword() {
        // No-op
    }

    @Override
    public PasswordState getPasswordState() throws AuthenticationException {
        // No-op
        return PasswordState.SET;
    }

    @Override
    public boolean isCallerAnonymous() {
        return false;
    }

    @Override
    public boolean supportsPasswordChange() throws PasswordChangeAllowedException, UnsupportedPasswordException {
        return true;
    }
}

public class Main {

    public static void main(String[] args) {
        CustomCredentialValidator credentialValidator = new CustomCredentialValidator("admin");

        // PasswordAuthentication will fail if the user credentials are incorrect
        // This is a placeholder for a more secure application
        if ("admin".equals(credentialValidator.getPassword())) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}