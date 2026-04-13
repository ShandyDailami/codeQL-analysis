import java.util.Arrays;
import java.util.Base64;

public class java_34757_CredentialValidator_A07 {
    // Hard-coded passwords for demonstration purposes.
    private static final String[] hardCodedPasswords = {"admin", "user1", "user2"};

    // This method attempts to authenticate with the given credentials.
    public boolean authenticate(String username, String password) {
        String decodedPassword = new String(Base64.getDecoder().decode(password));

        // Assume the password is base64 encoded.
        return Arrays.asList(hardCodedPasswords).contains(decodedPassword);
    }
}