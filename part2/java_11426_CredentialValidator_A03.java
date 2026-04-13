import java.util.Base64;

public class java_11426_CredentialValidator_A03 {

    public boolean validateCredentials(String username, String password) {
        // Realistically, the username and password are never sent in plain text
        // They should be hashed or encrypted before sending

        // For the sake of simplicity, let's assume a simple username and password match
        // This should be replaced with a real comparison using hashed or encrypted passwords
        return username.equals("admin") && password.equals("password");
    }
}