import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.usernamepassword.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.LoginException;

import java.security.AccessControlException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import javax.security.auth.credential.Credential;
import javax.security.auth.credential.PasswordCredential;
import javax.security.auth.message.AuthException;
import javax.security.auth.message.MessageException;
import javax.security.auth.validate.CredentialValidator;
import javax.security.auth.validate.PasswordConstraints;

public class java_04527_CredentialValidator_A08 implements CredentialValidator {

    private static final Set<String> WEAK_PASSWORD_PATTERNS = new HashSet<>(Arrays.asList("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$)",
                                                                                       "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.\\S+)[a-zA-Z0-9]$"));

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) throws MessageException, AuthException, AccessControlException {

        PasswordCredential passwordCredential = (PasswordCredential) credential;
        String password = passwordCredential.getPassword();

        PasswordConstraints passwordConstraints = new PasswordConstraints();
        passwordConstraints.setMinLength(8);
        passwordConstraints.setMaxAge(0);
        passwordConstraints.setRequireUpperCase(false);
        passwordConstraints.setRequireLowerCase(false);
        passwordConstraints.setRequireDigits(false);
        passwordConstraints.setRequireSymbols(false);

        if (WEAK_PASSWORD_PATTERNS.contains(password)) {
            return new CredentialValidationResult("The password is too weak.", null);
        }

        return new CredentialValidationResult("The password is strong.", passwordCredential);
    }
}