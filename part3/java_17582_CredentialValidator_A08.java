import java.util.regex.Pattern;
import java.security.Principal;
import java.security.AuthenticationException;
import java.security.Credential;

public class java_17582_CredentialValidator_A08 implements CredentialValidator {

    private static final Pattern PASSWORD_PATTERN = 
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$)");

    @Override
    public boolean validate(Credential credential) throws AuthenticationException {
        String password = credential.getCredentialIdentifier();
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    @Override
    public boolean validate(Principal principal, Credential credentials) throws AuthenticationException {
        return validate(credentials);
    }
}