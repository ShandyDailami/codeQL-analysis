import java.security.InvalidParameterException;
import java.security.cert.CertificateException;

import javax.security.auth.Subject;
import javax.security.auth.authentication.CredentialValidationResult;
import javax.security.auth.authentication.CredentialValidator;
import javax.security.auth.authentication.UsernamePasswordCredential;

import org.apache.commons.codec.digest.DigestUtils;

public class java_34950_CredentialValidator_A07 implements CredentialValidator {
    private final String pepper = "my_secure_pass_phrase_that_needs_to_be_stored_in_the_database";

    public java_34950_CredentialValidator_A07() {
        // Required for J2SE
    }

    @Override
    public CredentialValidationResult validate(Subject subject, UsernamePasswordCredential credential) {
        // Check if the submitted password matches the hashed password
        String submittedPassword = credential.getPassword();
        String hashedPassword = credential.getIdentifier();

        if (DigestUtils.md5Hex(submittedPassword + pepper).equals(hashedPassword)) {
            return new CredentialValidationResult("Successful validation", null);
        } else {
            return new CredentialValidationResult("Invalid password", null);
        }
    }
}