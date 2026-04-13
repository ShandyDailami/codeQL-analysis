import java.util.Base64;

public class java_31241_CredentialValidator_A07 {

    // Hashed password in Base64
    private static final String BASE64_ENCODED_PASSWORD = "YWJjZGVmZw==";

    public static void main(String[] args) {
        String username = "user";
        String password = "password";
        String inputPassword = "inputPassword";

        if (isValidCredentials(username, password, inputPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    private static boolean isValidCredentials(String username, String hashedPassword, String inputPassword) {
        // Decode the password
        byte[] decodedPassword = Base64.getDecoder().decode(hashedPassword);
        
        // Compare the hashed password and the input password
        return Arrays.equals(decodedPassword, inputPassword.getBytes());
    }
}