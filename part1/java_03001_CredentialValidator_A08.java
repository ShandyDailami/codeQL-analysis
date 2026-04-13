import java.util.Base64;
import java.util.HashMap;

public class java_03001_CredentialValidator_A08 {

    // Hardcoded username and passwords for testing
    private HashMap<String, String> hardcodedCredentials = new HashMap<>();

    public java_03001_CredentialValidator_A08() {
        hardcodedCredentials.put("alice", Base64.getEncoder().encodeToString("alice123".getBytes()));
        hardcodedCredentials.put("bob", Base64.getEncoder().encodeToString("bob123".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        // Check if password matches hardcoded password
        if (hardcodedCredentials.containsKey(username) && 
            hardcodedCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

}