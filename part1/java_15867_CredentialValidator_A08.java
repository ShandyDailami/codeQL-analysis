import java.util.HashMap;

public class java_15867_CredentialValidator_A08 {

    private HashMap<String, String> userCredentials;

    public java_15867_CredentialValidator_A08() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1"); // Add more users as needed
    }

    public boolean validateCredentials(String username, String password) {
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}