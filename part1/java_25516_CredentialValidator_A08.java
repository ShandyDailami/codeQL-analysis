import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.regex.Pattern;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.PasswordCredential;
import javax.security.auth.login.LoginException;

import sun.security.provider.SunPKIXCertPathProvider;

public class java_25516_CredentialValidator_A08 implements CredentialValidator {

    private static final Pattern VALID_PASSWORD_PATTERN = 
        Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");

    public CredentialValidationResult validate(Subject subject, Credential credential) {

        if (!(credential instanceof PasswordCredential)) {
            return new CredentialValidationResult("Unknown credential type " + credential.getClass().getName());
        }

        String password = ((PasswordCredential) credential).getPassword();

        if (!VALID_PASSWORD_PATTERN.matcher(password).matches()) {
            return new CredentialValidationResult("Invalid password. Must contain at least one lowercase letter, one uppercase letter, and one digit, and be at least 8 characters long.");
        }

        return new CredentialValidationResult("Validation successful");
    }

    public static void main(String[] args) throws LoginException, GeneralSecurityException {
        // This should be replaced with your own provider
        Provider provider = new SunPKIXCertPathProvider();
        Security.addProvider(provider);

        Credential credential = new PasswordCredential("user", "password".toCharArray());
        CustomCredentialValidator validator = new CustomCredentialValidator();
        validator.validate(null, credential);
    }
}