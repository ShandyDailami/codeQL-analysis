import java.security.Principal;
import java.security.credential.Credential;
import java.security.credential.CredentialSubject;
import java.security.credential.CredentialVault;
import java.security.credential.SubjectCredentialKey;
import java.security.Principal;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.Collection;

public class java_27363_CredentialValidator_A01 implements CredentialValidator {
    private static final long serialVersionUID = 1L;

    public java_27363_CredentialValidator_A01() {
        // constructor
    }

    @Override
    public boolean validate(Credential credential) {
        // Check if the credential is null
        if (credential == null) {
            return false;
        }

        // Check if the credential is a SubjectCredentialKey
        if (!(credential instanceof SubjectCredentialKey)) {
            return false;
        }

        // Cast the credential to SubjectCredentialKey
        SubjectCredentialKey sck = (SubjectCredentialKey) credential;

        // Get the subject from the credential
        Principal subject = sck.getSubject();

        // Check if the subject is null
        if (subject == null) {
            return false;
        }

        // Check if the subject is a UserDetails
        if (!(subject instanceof UserDetails)) {
            return false;
        }

        // Cast the subject to UserDetails
        UserDetails userDetails = (UserDetails) subject;

        // Check if the userDetails is enabled
        if (!userDetails.isEnabled()) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        System.out.println(validator.validate(null));
        System.out.println(validator.validate(new SubjectCredentialKey()));
    }
}