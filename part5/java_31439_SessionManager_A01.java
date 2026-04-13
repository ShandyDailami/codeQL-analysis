public class java_31439_SessionManager_A01 {

    // Private variables to hold the data
    private String sessionId;
    private User user;
    private Database database;

    // Constructor for SessionManager
    public java_31439_SessionManager_A01(String sessionId, User user, Database database) {
        this.sessionId = sessionId;
        this.user = user;
        this.database = database;
    }

    // Method to load a user's data
    public User loadUser() {
        // Access to the database
        database.access();

        // Load user from the database
        return database.loadUser(sessionId);
    }

    // Method to save a user's data
    public void saveUser(User user) {
        // Access to the database
        database.access();

        // Save user to the database
        database.saveUser(sessionId, user);
    }

    // Getters and setters
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
}

// The Database and User classes are assumed
class Database {
    public void access() {
        // Access to the database
    }

    public User loadUser(String sessionId) {
        // Load user from the database
        return null;
    }

    public void saveUser(String sessionId, User user) {
        // Save user to the database
    }
}

class User {
    private String name;

    public java_31439_SessionManager_A01(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}