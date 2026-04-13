import java.security.InvalidParameterException;
import java.util.Base64;

public class java_16383_CredentialValidator_A01 {

    private static final String AUTHENTICATION_SCHEME = "Basic";

    private java_16383_CredentialValidator_A01() {} // Prevent instantiation

    public static boolean validate(String credential) {
        if (credential == null || credential.isEmpty()) {
            throw new InvalidParameterException("Credential must not be null or empty");
        }

        // Decode the base64 credential
        byte[] decodedBytes = Base64.getDecoder().decode(credential);
        String decodedCredential = new String(decodedBytes, "UTF-8");

        // Split the decoded credential into username and password
        String[] credentials = decodedCredential.split(":");

        if (credentials.length != 2) {
            throw new InvalidParameterException("Credential must be in the format 'username:password'");
        }

        String username = credentials[0];
        String password = credentials[1];

        // Simulate authentication by comparing with hardcoded values
        return authenticate(username, password);
    }

    private static boolean authenticate(String username, String password) {
        // Simulate the authentication process
        // Replace this with your actual authentication logic
        return "admin".equals(username) && "password".equals(password);
    }

    public static void main(String[] args) {
        // Test the validation
        boolean isValid = CredentialValidator.validate("YWJjZGVmZw==");
        System.out.println("Is valid: " + isValid);
    }
}