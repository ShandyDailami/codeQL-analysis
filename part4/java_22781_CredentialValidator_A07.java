import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_22781_CredentialValidator_A07 {

    private Map<String, String> userData;

    public java_22781_CredentialValidator_A07() {
        userData = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userData.put(username, password);
    }

    public boolean validateCredentials(String username, String password) {
        // Decoding the password from base64
        String encodedPassword = userData.get(username);
        if (encodedPassword != null) {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
            String decodedPassword = new String(decodedBytes);

            // Compare the decoded password with the given password
            return decodedPassword.equals(password);
        }

        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addUser("alice", "password123");

        boolean isValid = validator.validateCredentials("alice", "password123");
        System.out.println("Is valid: " + isValid);
    }
}