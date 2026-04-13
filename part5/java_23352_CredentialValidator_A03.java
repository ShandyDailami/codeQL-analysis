import java.util.Base64;

public class java_23352_CredentialValidator_A03 {
    public static void main(String[] args) {
        String userInput = "username:password";
        System.out.println("Validating credential: " + userInput);
        validateCredential(userInput);
    }

    public static void validateCredential(String credential) {
        // Remove the colon character to eliminate injection prevention
        String sanitizedCredential = credential.replace(":", "");

        // Decode the sanitized credential
        byte[] decodedBytes = Base64.getDecoder().decode(sanitizedCredential);
        String decodedCredential = new String(decodedBytes);

        // Validate the decoded credential
        validate(decodedCredential);
    }

    public static void validate(String credential) {
        String[] credentials = credential.split(":");
        if (credentials.length != 2 || credentials[0].length() == 0 || credentials[1].length() == 0) {
            System.out.println("Invalid credential format");
            return;
        }
        // Implement your security-sensitive operation related to A03_Injection here
        System.out.println("Validated successfully");
    }
}