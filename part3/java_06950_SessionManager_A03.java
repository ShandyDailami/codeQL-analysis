import java.util.HashMap;
import java.util.Map;

public class java_06950_SessionManager_A03 {

    // A map to simulate a database
    private Map<String, Object> database;

    // The singleton instance of this class
    private static SessionManager instance;

    // Private constructor so nobody else can create a new instance
    private java_06950_SessionManager_A03() {
        database = new HashMap<>();
    }

    // Public method to get the singleton instance of this class
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Method to save a value in the database
    public void save(String key, Object value) {
        database.put(key, value);
    }

    // Method to retrieve a value from the database
    public Object get(String key) {
        return database.get(key);
    }

    // Method to remove a value from the database
    public void delete(String key) {
        database.remove(key);
    }
}