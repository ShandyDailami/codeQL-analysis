import java.util.Base64;

public class java_06008_CredentialValidator_A07 {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";

    public boolean validate(String username, String password) {
        // Base64 decoding for username and password
        byte[] decodedBytesUsername = Base64.getDecoder().decode(username);
        byte[] decodedBytesPassword = Base64.getDecoder().decode(password);

        // Decoding username and password
        String decodedUsername = new String(decodedBytesUsername);
        String decodedPassword = new String(decodedBytesPassword);

        // Check if username and password matches
        if (decodedUsername.equals(ADMIN_USERNAME) && decodedPassword.equals(ADMIN_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        String username = "YWRtaW4="; // Base64 encoding of 'admin'
        String password = "YWRtaW4="; // Base64 encoding of 'password'
        if (validator.validate(username, password)) {
            System.out.println("Validated successfully!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}