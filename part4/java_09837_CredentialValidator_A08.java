import org.mindrot.jbcrypt.BCrypt;

public class java_09837_CredentialValidator_A08 {

    // This is a static class, so we can't use an instance to access the database.
    // The database is a part of the CredentialValidator class, not an instance of it.
    // You can create a CredentialValidator instance and pass it to the database to create and retrieve users.
    // This example uses a simple in-memory store, but you would use a database for a real application.
    private static UserDatabase database = new UserDatabase();

    public static boolean validateCredentials(String username, String password) {
        User user = database.getUserByUsername(username);

        // If the user doesn't exist, return false
        if (user == null) {
            return false;
        }

        // If the password is incorrect, return false
        if (!BCrypt.checkpw(password, user.getHashedPassword())) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }

    private static class User {
        private String username;
        private String hashedPassword;

        public java_09837_CredentialValidator_A08(String username, String password) {
            this.username = username;
            this.hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        }

        public String getUsername() {
            return username;
        }

        public String getHashedPassword() {
            return hashedPassword;
        }
    }

    private static class UserDatabase {
        private List<User> users = new ArrayList<>();

        public java_09837_CredentialValidator_A08() {
            users.add(new User("user1", "password1"));
            users.add(new User("user2", "password2"));
        }

        public User getUserByUsername(String username) {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
            return null;
        }
    }
}