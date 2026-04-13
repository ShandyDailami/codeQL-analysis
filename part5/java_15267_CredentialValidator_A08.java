import java.util.HashMap;
import java.util.Map;

public class java_15267_CredentialValidator_A08 {

    // In a real world scenario, we would use a database to store user credentials
    private Map<String, String> userCredentials;

    public java_15267_CredentialValidator_A08() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1"); // This should be stored in a secure and encrypted manner
        userCredentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        return userCredentials.containsKey(user) && userCredentials.get(user).equals(password);
    }
}