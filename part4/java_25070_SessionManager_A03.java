import java.util.HashMap;
import java.util.Map;

public class java_25070_SessionManager_A03 {
    // Create a HashMap to simulate a database
    private Map<String, String> database;

    public java_25070_SessionManager_A03() {
        // Initialize the database
        database = new HashMap<>();
    }

    // Method to insert a key-value pair into the database
    public void insert(String key, String value) {
        database.put(key, value);
    }

    // Method to retrieve a value from the database based on a key
    public String get(String key) {
        // This is where security-sensitive operations would go
        // For now, we'll just return the value without any security checks
        return database.get(key);
    }

    // Method to update a value in the database
    public void update(String key, String value) {
        database.put(key, value);
    }

    // Method to delete a key-value pair from the database
    public void delete(String key) {
        database.remove(key);
    }
}