import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_32543_CredentialValidator_A01 {

    public static void main(String[] args) {
        // Create a password encoder
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Validate a user
        validateCredentials("user", "password", passwordEncoder);
    }

    private static void validateCredentials(String username, String password, PasswordEncoder passwordEncoder) {
        // Dummy credentials
        String dummyUsername = "user";
        String dummyPassword = "password";

        // Check if the provided password is correct
        if (passwordEncoder.matches(password, dummyPassword)) {
            System.out.println("Access granted for user: " + username);
        } else {
            System.out.println("Access denied for user: " + username);
        }
    }
}