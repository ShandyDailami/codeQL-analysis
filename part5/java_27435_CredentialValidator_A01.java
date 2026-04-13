import java.util.Arrays;
import java.util.List;

public class java_27435_CredentialValidator_A01 {

    private List<String> validPasswords = Arrays.asList("password1", "password2", "password3");

    public boolean isValidPassword(String passwordAttempt) {
        // First, we'll hash the password attempt using a secure hash function.
        // This is just an example, you would likely use a stronger hashing algorithm.
        String hashedPasswordAttempt = hashPassword(passwordAttempt);

        // Then, we'll check if the hashed password attempt is in our list of valid passwords.
        return validPasswords.contains(hashedPasswordAttempt);
    }

    private String hashPassword(String password) {
        // This is a very simple example of hashing a password, you would likely use a more complex algorithm.
        // In a real-world scenario, you would use a stronger hashing algorithm.
        return String.valueOf(password.hashCode());
    }
}