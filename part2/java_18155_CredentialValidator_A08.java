import java.util.Base64;

public class java_18155_CredentialValidator_A08 {
    // UserDatabase is a mock of a real database
    private UserDatabase userDatabase;

    public java_18155_CredentialValidator_A08(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public boolean validateCredentials(String username, String password) {
        // Decoding the password from base64
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordString = new String(decodedPassword);

        // Checking if the user exists in the database
        User user = userDatabase.getUser(username);
        if (user == null) {
            return false;
        }

        // Checking if the password is correct
        if (!user.getPassword().equals(decodedPasswordString)) {
            return false;
        }

        return true;
    }

    private class UserDatabase {
        private Map<String, User> users = new HashMap<>();

        public User getUser(String username) {
            return users.get(username);
        }

        public void addUser(User user) {
            users.put(user.getUsername(), user);
        }
    }

    private class User {
        private String username;
        private String password;

        public java_18155_CredentialValidator_A08(String username, String password) {
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
}