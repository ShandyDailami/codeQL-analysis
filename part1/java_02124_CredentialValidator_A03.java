import java.util.Base64;

public class java_02124_CredentialValidator_A03 {

    // The method for the validation
    public boolean validateCredentials(String user, String password) {
        // Convert user and password to Base64 format
        String encodedUser = Base64.getEncoder().encodeToString(user.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Check if the encoded user and password matches a hard-coded user and password
        // This is a very simple way to check for insecure credentials
        // In a real application, you would use a secure way to store and compare hashed passwords
        if (encodedUser.equals("dXNlcjpwYXNz") && encodedPassword.equals("dXNlcjpwYXNz")) {
            return true;
        } else {
            return false;
        }
    }
}