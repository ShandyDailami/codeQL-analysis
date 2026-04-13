import java.security.InvalidParameterException;
import java.util.regex.Pattern;

public class java_33018_CredentialValidator_A01 {
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    private Credential credential;

    public java_33018_CredentialValidator_A01(Credential credential) {
        if (credential == null) {
            throw new InvalidParameterException("Credential object cannot be null");
        }
        this.credential = credential;
    }

    public boolean validatePassword() {
        if (credential.getPassword() == null) {
            return false;
        }
        return VALID_PASSWORD_PATTERN.matcher(credential.getPassword()).matches();
    }

    public Credential getCredential() {
        return credential;
    }
}