import java.util.Base64;

public class java_35530_CredentialValidator_A01 {

    // Simple username and password. For a real application, this should be encrypted or securely stored.
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    public boolean validate(String username, String password) {
        // Decode the username and password
        byte[] decodedUsername = Base64.getDecoder().decode(username);
        byte[] decodedPassword = Base64.getDecoder().decode(password);

        // Convert bytes to String and compare
        String decodedUsernameStr = new String(decodedUsername);
        String decodedPasswordStr = new String(decodedPassword);

        if (decodedUsernameStr.equals(USERNAME) && decodedPasswordStr.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}