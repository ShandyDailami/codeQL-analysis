import java.util.Base64;
import java.util.Base64.Decoder;

public class java_36457_CredentialValidator_A01 {
    private static final String VALID_CREDENTIALS = "validCredentials";
    private static final String BASIC_AUTH = "Basic ";

    private java_36457_CredentialValidator_A01() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Decoder decoder = Base64.getDecoder();
        String credentials = new String(decoder.decode(VALID_CREDENTIALS), "UTF-8");
        String[] parts = credentials.split(":");
        String username = parts[0];
        String password = parts[1];

        validateCredentials(username, password);
    }

    public static void validateCredentials(String username, String password) {
        if (isValidUser(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    private static boolean isValidUser(String username, String password) {
        // Simulate a security-sensitive operation, e.g., comparing passwords
        // For simplicity, this method just checks if the username is "admin" and the password is "password"
        return username.equals("admin") && password.equals("password");
    }
}