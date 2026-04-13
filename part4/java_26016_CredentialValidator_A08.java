import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

public class java_26016_CredentialValidator_A08 {
    public static class ValidationResult {
        public boolean isValid;
        public String errorMessage;

        public java_26016_CredentialValidator_A08(boolean isValid, String errorMessage) {
            this.isValid = isValid;
            this.errorMessage = errorMessage;
        }
    }

    public ValidationResult validateCredential(X509Certificate credential) throws GeneralSecurityException {
        // Create a dummy credential and validate it.
        // In a real application, you would use a library like Bouncy Castle or Java's own CertificateFactory.
        // If the validation fails, return an error message.

        // For the sake of this example, let's just return a simple error message.
        // In a real application, you would replace this with a more complex validation logic.
        if (credential == null) {
            return new ValidationResult(false, "Credential cannot be null.");
        }

        if (credential.getIssuerDN().toString().equals("Dummy Issuer")) {
            return new ValidationResult(false, "Issuer is not valid.");
        }

        if (credential.getNotAfter().before(java.util.Calendar.getInstance().getTime())) {
            return new ValidationResult(false, "Credential has expired.");
        }

        // If no errors, the credential is valid.
        return new ValidationResult(true, "");
    }
}