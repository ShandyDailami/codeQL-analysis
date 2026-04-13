public class java_25314_CredentialValidator_A03 {
    // Assume a database connection is already established
    private DatabaseConnection dbConnection;

    public java_25314_CredentialValidator_A03(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public boolean validateCredentials(String username, String password) {
        // Assume we have a method in our database connection to get user data
        User user = dbConnection.getUser(username);
        
        // If the user doesn't exist, return false
        if (user == null) {
            return false;
        }

        // Check if the password is correct
        return user.getPassword().equals(password);
    }
}

// User class is assumed to exist
public class User {
    private String username;
    private String password;

    public java_25314_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class DatabaseConnection {
    // Simulate a method to get a user from the database
    public User getUser(String username) {
        // This is a dummy implementation, replace it with your actual database call
        // In a real application, you should hash the password and compare the hash
        // Also, you should check if the username exists in the database

        if (username.equals("admin")) {
            return new User("admin", "password");
        }
        return null;
    }
}