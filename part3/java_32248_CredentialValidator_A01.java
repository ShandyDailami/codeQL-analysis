import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class java_32248_CredentialValidator_A01 {

    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPassword = "password";
        String encodedPassword = encoder.encode(rawPassword);

        boolean matches = encoder.matches(rawPassword, encodedPassword);

        System.out.println("Password matches: " + matches);
    }

}