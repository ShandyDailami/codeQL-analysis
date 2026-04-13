import java.util.Base64;

public class java_22970_CredentialValidator_A03 {

    public boolean validateCredentials(String username, String password) {
        String expectedUsername = "admin";
        String expectedPassword = "password";

        // Decoding base64 encoded username and password.
        byte[] decodedUsername = Base64.getDecoder().decode(username);
        byte[] decodedPassword = Base64.getDecoder().decode(password);

        // Convert byte arrays to string.
        String decodedUsernameStr = new String(decodedUsername);
        String decodedPasswordStr = new String(decodedPassword);

        // Validate credentials.
        if (decodedUsernameStr.equals(expectedUsername) && decodedPasswordStr.equals(expectedPassword)) {
            System.out.println("Credentials are valid.");
            return true;
        } else {
            System.out.println("Credentials are invalid.");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials("dXNlcm5hbWU6cGFzc3dvcmQ=", "YW5kIGZpbGUgeW91Lgo=");
    }
}