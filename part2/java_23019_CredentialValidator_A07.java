import java.util.Base64;
import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;

public class java_23019_CredentialValidator_A07 implements CredentialValidator {

    // Store the hard-coded password in Base64
    private String hardCodedPassword;

    public java_23019_CredentialValidator_A07(String password) {
        this.hardCodedPassword = password;
    }

    @Override
    public String getCallerPrincipal() {
        return "user";
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean validate(Object credentials) throws InvalidCredentialException {
        // Convert the hard-coded password to bytes
        byte[] passwordBytes = this.hardCodedPassword.getBytes();
        String base64Password = Base64.getEncoder().encodeToString(passwordBytes);

        // Convert the provided password to bytes
        byte[] providedPasswordBytes = ((String) credentials).getBytes();
        String base64ProvidedPassword = Base64.getEncoder().encodeToString(providedPasswordBytes);

        // Compare the encrypted passwords
        return base64Password.equals(base64ProvidedPassword);
    }
}