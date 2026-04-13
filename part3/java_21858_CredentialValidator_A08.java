import java.util.Base64;

public class java_21858_CredentialValidator_A08 {

    // In a real application, these would be encrypted
    private static final String USERNAME = "testuser";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        // Base64 decoding is used for comparison
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        return USERNAME.equals(username) && PASSWORD.equals(new String(decodedPassword));
    }
}