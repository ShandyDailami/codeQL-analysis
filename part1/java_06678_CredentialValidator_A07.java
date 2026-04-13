import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.validation.DefaultValidationResult;
import javax.security.auth.validation.ValidationResult;
import javax.security.auth.validation.Validator;
import javax.security.auth.validation.ValidatorResult;

public class java_06678_CredentialValidator_A07 implements Validator {

    @Override
    public ValidatorResult validate(Subject subject, CredentialCredential credential) {
        if ("test".equals(credential.getIdentifier())) {
            return new DefaultValidationResult("Success", "A07_AuthFailure", "");
        } else {
            return new DefaultValidationResult("Unknown Credential", "A07_AuthFailure", "");
        }
    }

    public static class CredentialCredential {
        private String identifier;

        public java_06678_CredentialValidator_A07(String identifier) {
            this.identifier = identifier;
        }

        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }
    }
}