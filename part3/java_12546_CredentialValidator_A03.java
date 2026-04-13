import javax.security.auth.Credential;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.login.CredentialException;

public class java_12546_CredentialValidator_A03 {

    // No external dependencies, no Spring or Hibernate dependencies,
    // no external frameworks, no external libraries.

    // Realistic comment:
    /*
     * This is a simple CredentialValidator that does not require any security-sensitive
     * operations and is only using standard Java libraries. It validates if the given
     * password matches the expected password.
     */

    private String expectedPassword;

    public java_12546_CredentialValidator_A03(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    // Realistic comment:
    /*
     * This method validates if the given Credential matches the expected password.
     * If the passwords do not match, it throws a CredentialException.
     * If the passwords do not match, it throws a PasswordChangeException.
     */

    public void validate(Credential credential) throws CredentialException, PasswordChangeException {
        String providedPassword = credential.getPassword();

        if (!providedPassword.equals(expectedPassword)) {
            throw new CredentialException("Provided password does not match expected password.");
        }
    }
}