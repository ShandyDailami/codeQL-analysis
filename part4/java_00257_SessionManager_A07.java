import java.util.HashMap;
import java.util.Map;

public class java_00257_SessionManager_A07 {
    private Map<String, String> credentials;

    public java_00257_SessionManager_A07() {
        // Initialize the credentials map. This will simulate a database for storing credentials.
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean authenticate(String username, String password) {
        // Check if the username and password combination is valid.
        // Here we just check if the credentials map contains the username and password.
        // In a real-world scenario, you would typically compare the passwords hashed and salted in the database.
        return this.credentials.containsKey(username) && this.credentials.get(username).equals(password);
    }
}