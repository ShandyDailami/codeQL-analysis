import java.util.Base64;
import java.util.Arrays;

public class java_09405_CredentialValidator_A03 {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        // In a real-world scenario, passwords should never be stored in plain text.
        // For simplicity, we will store them in base64.
        // In a real-world scenario, passwords should be stored in hashed form.
        // The hashed form is stored in the database.
        // The hashed form is used to verify the password.
        if (username.equals(VALID_USERNAME) && password.equals(Base64.getDecoder().decode(VALID_PASSWORD))) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // Test the validate method.
        String username = "admin";
        String password = Base64.getEncoder().encodeToString("password".getBytes());
        if (validate(username, password)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}