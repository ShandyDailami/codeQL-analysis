import java.util.Base64;

public class java_13438_CredentialValidator_A03 {

    // This is a simple example of a credential validator. In a real-world scenario,
    // you would use more sophisticated methods to check if the provided username and password
    // match a valid user in your system.

    public boolean isValidCredentials(String username, String password) {
        // This is a simple encoding. In a real-world scenario, you would not store passwords in plain text.
        // For simplicity, we're only checking the username and password.
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        String decodedPassword = new String(decodedBytes);

        if (username.equals("admin") && decodedPassword.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}