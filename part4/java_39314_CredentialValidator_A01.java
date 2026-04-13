import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.LoginException;
import java.security.GeneralSecurityException;

public class java_39314_CredentialValidator_A01 implements CredentialValidator {

    // This is a simple static password that's not secure for real-world use
    private static final String DATABASE_PASSWORD = "secure_password";

    @Override
    public String validate(String arg0) throws InvalidCredentialException, LoginException, GeneralSecurityException {
        // Checking if the password provided by the user matches the password stored in the database
        if (!arg0.equals(DATABASE_PASSWORD)) {
            throw new InvalidCredentialException("Invalid password");
        }
        return null;
    }

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException, LoginException, GeneralSecurityException {
        return validate(credential.getPassword());
    }
}