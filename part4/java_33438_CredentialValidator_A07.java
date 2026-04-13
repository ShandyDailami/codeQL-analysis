import java.security.auth.Credential;
import java.security.auth.LoginException;
import java.util.regex.Pattern;

public class java_33438_CredentialValidator_A07 implements java.security.auth.CredentialValidator {

    private Pattern pattern;

    public java_33438_CredentialValidator_A07() {
        // Define the pattern for a strong password
        pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
    }

    @Override
    public Credential validate(Credential credential) throws LoginException {
        String password = credential.getPassword();
        if (!pattern.matcher(password).matches()) {
            throw new LoginException("Invalid password");
        }
        return credential;
    }
}