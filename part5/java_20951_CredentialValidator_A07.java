import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.subject.Subject;
import javax.security.auth.validation.AbstractValidator;
import javax.security.auth.validation.ValidationResult;

public class java_20951_CredentialValidator_A07 extends AbstractValidator
{
    private String[] userRoles;

    public java_20951_CredentialValidator_A07(String[] userRoles) {
        this.userRoles = userRoles;
    }

    public CredentialValidationResult validate(Subject subject, Credential credential)
    {
        if (credential instanceof UsernamePasswordCredential)
        {
            UsernamePasswordCredential upCredential = (UsernamePasswordCredential) credential;
            String username = upCredential.getUsername();
            char[] password = upCredential.getPassword();

            // Here, you can use the username and password for real-world operations

            // Let's assume this is our 'database' or 'real' credentials store
            if (username.equals("test") && Arrays.equals(password, new char[]{'t', 'e', 's', 't'}))
            {
                return new ValidationResult("Success");
            }
        }

        return new ValidationResult("Failure");
    }
}