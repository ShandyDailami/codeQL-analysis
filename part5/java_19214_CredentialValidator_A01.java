import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.SubjectImpl;
import javax.security.auth.message.AuthException;
import javax.security.auth.credential.PasswordCredential;
import javax.security.auth.credential.CredentialValidationResult;
import javax.security.auth.credential.UnavailableCredentialException;

public class java_19214_CredentialValidator_A01 {

    public CredentialValidationResult validate(Credential credential) throws UnavailableCredentialException, AuthException, LoginException {
        // Check if the provided credential is a UsernamePasswordCredential
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;

            // Check if the provided username and password match
            if ("user".equals(usernamePasswordCredential.getUsername()) && "password".equals(new String(usernamePasswordCredential.getPassword()))) {
                return CredentialValidationResult.VALID;
            } else {
                return CredentialValidationResult.NOT_VALIDATED_MAY_BE_EXPIRED;
            }
        }

        // If the provided credential is not a UsernamePasswordCredential, it must be a PasswordCredential
        else if (credential instanceof PasswordCredential) {
            PasswordCredential passwordCredential = (PasswordCredential) credential;

            // Check if the provided password matches
            if ("password".equals(new String(passwordCredential.getPassword()))) {
                return CredentialValidationResult.VALID;
            } else {
                return CredentialValidationResult.NOT_VALIDATED_MAY_BE_EXPIRED;
            }
        }

        // If the provided credential is neither a UsernamePasswordCredential nor a PasswordCredential, it must be a plain text credential
        else {
            // Check if the provided plain text credential matches
            if ("plainText".equals(new String(credential.getCredential()))) {
                return CredentialValidationResult.VALID;
            } else {
                return CredentialValidationResult.NOT_VALIDATED_MAY_BE_EXPIRED;
            }
        }
    }

    public static void main(String[] args) {
        CredentialValidator credentialValidator = new CredentialValidator();

        // Create a new subject
        Subject subject = new SubjectImpl();

        // Add the subject to the authentication authority
        subject.getPrincipal().add(new UsernamePasswordCredential("user", "password"));
        subject.getPrincipal().add(new PasswordCredential("password"));
        subject.getPrincipal().add(new PasswordCredential("plainText"));

        // Validate the subject
        System.out.println(credentialValidator.validate(subject));
    }
}