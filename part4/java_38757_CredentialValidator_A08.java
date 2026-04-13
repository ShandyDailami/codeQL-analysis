import java.util.Base64;
import java.util.HashMap;

public class java_38757_CredentialValidator_A08 {

    // Using HashMap for storage of users' credentials
    private HashMap<String, String> credentialMap = new HashMap<String, String>();

    // Constructor to create a new credential validator
    public java_38757_CredentialValidator_A08() {
        // Add some sample credentials to the map
        credentialMap.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        credentialMap.put("user1", Base64.getEncoder().encodeToString("user1:user1".getBytes()));
    }

    // Method to authenticate a user
    public boolean authenticate(String user, String password) {
        // Convert the entered password into bytes
        byte[] enteredPassword = password.getBytes();

        // Decode the existing password from the map
        String existingPassword = new String(Base64.getDecoder().decode(credentialMap.get(user)));

        // Compare the decoded passwords
        return enteredPassword.equals(existingPassword.getBytes());
    }
}