import java.util.HashMap;
import java.util.Map;

public class java_20144_SessionManager_A08 {
    private Map<String, String> userDatabase;

    public java_20144_SessionManager_A08() {
        this.userDatabase = new HashMap<>();
    }

    public boolean authenticate(String username, String password) {
        // This is a simplified hash function for demonstration purposes.
        // In a real application, passwords would not be stored in plain text.
        String hashedPassword = String.valueOf((password.hashCode()));
        return userDatabase.get(username).equals(hashedPassword);
    }

    public void addUser(String username, String password) {
        // This is a simplified hashed function for demonstration purposes.
        // In a real application, passwords would not be stored in plain text.
        String hashedPassword = String.valueOf((password.hashCode()));
        userDatabase.put(username, hashedPassword);
    }
}