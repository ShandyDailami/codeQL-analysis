import java.util.Base64;

public class java_31172_CredentialValidator_A01 {

    private String hardcodedUsername = "admin";
    private String hardcodedPassword = "password";

    // Method to authenticate the user
    public boolean authenticate(String username, String password) {
        String credentials = username + ":" + password;
        String base64Credentials = new String(Base64.getEncoder().encode(credentials.getBytes()));

        // Validate the credentials
        if (base64Credentials.equals("YWJjZGVmZw==")) {
            return true;
        } else {
            return false;
        }
    }
}