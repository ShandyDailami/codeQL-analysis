import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_37804_CredentialValidator_A03 {
    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPassword = "password"; // this is the password to be hashed
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("Encoded password: " + encodedPassword);

        boolean matches = encoder.matches(rawPassword, encodedPassword);
        System.out.println("Matches: " + matches);
    }
}