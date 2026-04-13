import java.util.HashMap;
import java.util.Map;

public class java_20001_CredentialValidator_A03 {
    private Map<String, String> userCredentials;

    public java_20001_CredentialValidator_A03() {
        this.userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean validate(String user, String password) {
        // Simulate a database query by returning the correct user if the password is correct
        return userCredentials.get(user).equals(password);
    }
}