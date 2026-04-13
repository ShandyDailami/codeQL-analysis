import java.util.HashMap;
import java.util.Map;

public class java_26163_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_26163_CredentialValidator_A03() {
        // Use a HashMap for storing user credentials
        this.credentials = new HashMap<>();
        // Add some default credentials
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        // Check if the given credentials are valid
        if(this.credentials.containsKey(user) && this.credentials.get(user).equals(password)) {
            System.out.println("Credentials are valid");
            return true;
        } else {
            System.out.println("Credentials are not valid");
            return false;
        }
    }
}