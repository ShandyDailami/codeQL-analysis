import java.security.InvalidParameterException;
import java.util.Base64;

public class java_02107_CredentialValidator_A08 {
    private static final String AUTHENTICATOR = "BASIC";

    public static boolean validate(String user, String password) {
        // Convert username and password to bytes
        String userPassword = user + ":" + password;
        byte[] userPasswordBytes = userPassword.getBytes();

        // Encode user password with Base64
        String encodedPassword = Base64.getEncoder().encodeToString(userPasswordBytes);

        // Validate user and password
        if (AUTHENTICATOR.equals(userPassword)) {
            throw new InvalidParameterException("Invalid username or password");
        }

        // Return true if everything is correct
        return true;
    }

    public static void main(String[] args) {
        try {
            validate("user", "password");
            System.out.println("Validated successfully");
        } catch (InvalidParameterException e) {
            System.out.println("Error validating credentials: " + e.getMessage());
        }
    }
}