public class java_21251_CredentialValidator_A03 {

    private Database database;

    public java_21251_CredentialValidator_A03(Database database) {
        this.database = database;
    }

    public boolean validateCredentials(String username, String password) {
        // Step 1: Fetch user data from the database
        User user = database.getUser(username);

        // Step 2: Validate password
        return user != null && user.getPassword().equals(password);
    }
}

public class User {

    private String username;
    private String password;

    public java_21251_CredentialValidator_A03(String username, String password) {
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

public class Database {

    private Map<String, User> users;

    public java_21251_CredentialValidator_A03() {
        users = new HashMap<>();
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));
    }

    public User getUser(String username) {
        return users.get(username);
    }
}