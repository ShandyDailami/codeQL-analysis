import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_27387_CredentialValidator_A03 {

    private final PasswordEncoder passwordEncoder;

    public java_27387_CredentialValidator_A03() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean validate(String password) {
        // a simple validation: password must be at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // a simple validation: password must contain at least one uppercase letter, one lowercase letter, and one digit
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // if all checks pass, the password is valid
        return true;
    }

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String password = "strongPassword@123";
        if (validator.validate(password)) {
            String encodedPassword = validator.encodePassword(password);
            System.out.println("Encoded password: " + encodedPassword);
        } else {
            System.out.println("Invalid password");
        }
    }
}