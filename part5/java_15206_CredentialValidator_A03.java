import java.security.InvalidParameterException;

public class java_15206_CredentialValidator_A03 {

    // This method is a simple validation that checks if a string is non-empty
    private static boolean isNonEmpty(String input) {
        return input != null && !input.isEmpty();
    }

    // This method is a simple validation that checks if a string is a valid email
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email != null && email.matches(emailRegex);
    }

    // This method is a simple validation that checks if a string is a valid password
    private static boolean isValidPassword(String password) {
        // In a real-world application, you would probably want to use a more complex password validation method
        return password != null && !password.isEmpty();
    }

    // This method validates the provided credentials
    public static boolean validateCredentials(String username, String password, String email) {
        if (!isNonEmpty(username) || !isNonEmpty(password) || !isNonEmpty(email)) {
            throw new InvalidParameterException("Username, password and email cannot be empty");
        }

        if (!isValidEmail(email) || !isValidPassword(password)) {
            throw new InvalidParameterException("Invalid email or password");
        }

        // In a real-world application, you would also want to hash the password before comparing it with the hash stored in the database
        // and store the hash for future comparison
        // This is a simplified example and a real-world application would require more complex password validation and storage

        return true;
    }
}