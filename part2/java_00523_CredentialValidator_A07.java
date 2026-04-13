import java.util.Base64;
import java.util.Optional;

public class java_00523_CredentialValidator_A07 {

    // This method checks if the given plain text password matches the hashed password
    // The hashed password is stored in the database
    public Optional<String> validatePassword(String plainTextPassword, String hashedPassword) {
        // In a real-world application, you should not store hashed passwords in plain text
        // You should use a library like Bcrypt or Java's in-built password hashing

        // This is a simple example, it doesn't actually hash the passwords or verify them
        // It just checks if the plain text password matches the hashed password

        if (plainTextPassword == null || hashedPassword == null) {
            return Optional.empty();
        }

        if (plainTextPassword.equals(hashedPassword)) {
            return Optional.of(plainTextPassword);
        } else {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        SecureCredentialValidator validator = new SecureCredentialValidator();
        String hashedPassword = Base64.getEncoder().encodeToString("myPassword".getBytes()); // This should be done in a real-world application

        Optional<String> validatedPassword = validator.validatePassword("myPassword", hashedPassword);

        if (validatedPassword.isPresent()) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is not valid");
        }
    }
}