import java.security.InvalidParameterException;
import java.util.Base64;

public class java_04198_CredentialValidator_A07 {
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";

    public boolean isValidCredentials(String credentials) {
        // Remove the comment and convert the string credentials to bytes
        byte[] decodedBytes = Base64.getDecoder().decode(credentials);
        String decodedString = new String(decodedBytes);

        // Split the string by ':' to get username and password
        String[] credentialsArray = decodedString.split(":");

        // Check if the number of credentials is correct
        if (credentialsArray.length != 2) {
            throw new InvalidParameterException("Invalid number of credentials");
        }

        // Check if the credentials are in the correct format
        if (!(credentialsArray[0].equals(USERNAME_KEY) && credentialsArray[1].equals(PASSWORD_KEY))) {
            throw new InvalidParameterException("Credentials format is incorrect");
        }

        // Check if the password is not empty
        if (credentialsArray[1].isEmpty()) {
            throw new InvalidParameterException("Password cannot be empty");
        }

        // All checks passed, return true
        return true;
    }
}