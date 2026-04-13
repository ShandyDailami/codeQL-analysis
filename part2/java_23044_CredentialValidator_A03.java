import java.util.HashMap;

public class java_23044_CredentialValidator_A03 {
    private HashMap<String, String> credentials;

    public java_23044_CredentialValidator_A03() {
        credentials = new HashMap<>();
        // add some sample credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}