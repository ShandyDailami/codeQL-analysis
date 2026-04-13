import java.security.InvalidParameterException;
import java.util.Base64;

public class java_10516_CredentialValidator_A01 {
    // This is a placeholder for the actual validation. Replace it with your actual implementation.
    private static boolean validateUserCredentials(String userName, String password) {
        // Here you would typically use an authentication service or library to validate the username and password.
        // For the sake of this example, we'll just check if they are both empty.
        return !(userName.isEmpty() || password.isEmpty());
    }

    // The actual method that will be used for validation.
    public static String validate(String userName, String password) {
        if (!validateUserCredentials(userName, password)) {
            throw new InvalidParameterException("Invalid username or password");
        }

        // Encode the username and password as a Base64 string.
        String encodedCredentials = Base64.getEncoder().encodeToString((userName + ":" + password).getBytes());

        return encodedCredentials;
    }
}