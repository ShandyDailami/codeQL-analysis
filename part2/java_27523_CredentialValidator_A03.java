import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Optional;

public class java_27523_CredentialValidator_A03 {

    private final static String ADMIN_PASSWORD = "YOUR_ADMIN_PASSWORD_BASE64"; // Replace with your actual admin password

    public Optional<String> validate(String passwordAttempt) {
        if (passwordAttempt == null) {
            throw new InvalidParameterException("Password parameter is null");
        }

        byte[] decodedBytes = Base64.getDecoder().decode(ADMIN_PASSWORD);
        String adminPassword = new String(decodedBytes);

        if (!passwordAttempt.equals(adminPassword)) {
            return Optional.of("Invalid password");
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String password = "YOUR_PASSWORD_BASE64"; // Replace with your actual password
        validator.validate(password)
                 .ifPresent(message -> System.out.println(message));
    }
}