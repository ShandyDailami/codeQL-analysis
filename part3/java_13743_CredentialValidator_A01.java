import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.mechanism.callback.AppSpecificCallBack;
import javax.security.auth.mechanism.callback.CallbackState;
import javax.security.auth.mechanism.callback.UnsupportedCallbackException;
import javax.security.auth.mechanism.callback.StateCallback;
import javax.security.auth.mechanism.callback.StateCallbackHandler;
import javax.security.auth.mechanism.password.PasswordChangeAllowedCallback;
import javax.security.auth.mechanism.password.PasswordChangeAllowedMechanism;
import javax.security.auth.mechanism.password.PasswordState;
import javax.security.auth.mechanism.password.PasswordValidationRequest;
import javax.security.auth.mechanism.UnavailableException;

public class java_13743_CredentialValidator_A01 implements CredentialValidator {
    public String getPasswordName() {
        return "Custom";
    }

    public CredentialValidationResult validate(Credential credential) {
        UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
        String password = usernamePasswordCredential.getPassword();
        
        if (password.length() < 8) {
            return new CredentialValidationResult("Password length should be at least 8 characters");
        }
        
        if (!password.matches(".*[0-9].*")) {
            return new CredentialValidationResult("Password should contain at least one digit");
        }
        
        if (!password.matches(".*[a-z].*")) {
            return new CredentialValidationResult("Password should contain at least one lower case letter");
        }
        
        if (!password.matches(".*[A-Z].*")) {
            return new CredentialValidationResult("Password should contain at least one upper case letter");
        }
        
        return new CredentialValidationResult("Password is valid");
    }
}