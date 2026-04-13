import java.util.HashMap;
import java.util.Map;

public class java_29019_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_29019_CredentialValidator_A01() {
        credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        credentials.put(username, password);
    }

    public boolean validate(String username, String password) {
        if (!credentials.containsKey(username)) {
            System.out.println("Username not found.");
            return false;
        }
        
        if (!credentials.get(username).equals(password)) {
            System.out.println("Password is incorrect.");
            return false;
        }
        
        System.out.println("Access granted.");
        return true;
    }
}