import java.util.Base64;
import java.util.regex.Pattern;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.store.CredentialValidationResult;
import javax.security.auth.store.UsernamePasswordCredentialValidationResult;

public class java_31801_CredentialValidator_A07 {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    public CredentialValidationResult validate(Credential credential) throws LoginException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential upCredential = (UsernamePasswordCredential) credential;
            String username = upCredential.getCaller();
            String password = new String(Base64.getDecoder().decode(upCredential.getPassword()));

            if (!USERNAME_PATTERN.matcher(username).matches() || !PASSWORD_PATTERN.matcher(password).matches()) {
                return new UsernamePasswordCredentialValidationResult("Invalid username or password");
            }
        }

        return new UsernamePasswordCredentialValidationResult("OK");
    }
}