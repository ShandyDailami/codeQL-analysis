import java.util.Base64;

public class java_36180_CredentialValidator_A03 {

    // Method to decode the credential
    public String decodeCredential(String credential) {
        return new String(Base64.getDecoder().decode(credential));
    }

    // Method to validate the decoded credential
    public boolean validateCredential(String credential) {
        // This is a placeholder for a real-world use case.
        // In a real-world scenario, you would need to compare the decoded credential 
        // with a database or some other form of storage.
        return true; // replace with your actual validation logic
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Encode a credential
        String credential = "YOUR_CREDENTIAL_HERE";
        String decodedCredential = validator.decodeCredential(credential);
        System.out.println("Decoded Credential: " + decodedCredential);

        // Validate the credential
        boolean isValid = validator.validateCredential(credential);
        System.out.println("Is Valid: " + isValid);
    }
}