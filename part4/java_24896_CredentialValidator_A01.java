import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.Subject;
import java.util.Arrays;

public class java_24896_CredentialValidator_A01 implements CredentialValidator {

    private final String username;
    private final char[] password;

    public java_24896_CredentialValidator_A01(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getCallerPrincipal() {
        return this.username;
    }

    @Override
    public char[] getPassword() {
        return this.password;
    }

    @Override
    public boolean validate(Subject subject, String callerPrincipal, char[] password) throws InvalidCredentialException {
        if (callerPrincipal != null && callerPrincipal.equals(this.username)) {
            if (Arrays.equals(password, this.password)) {
                return true;
            }
        }
        throw new InvalidCredentialException("Invalid username or password");
    }
}