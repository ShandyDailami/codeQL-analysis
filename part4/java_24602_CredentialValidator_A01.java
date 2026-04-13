public class java_24602_CredentialValidator_A01 {

    // Simulating a real world user database
    private static UserDatabase userDatabase = new UserDatabase();

    public boolean isValidCredentials(String username, String password) {
        User user = userDatabase.getUser(username);

        // Simulating a real world hash function
        String hashedPassword = hashPassword(password);

        // Simulating a real world comparison function
        return user != null && user.getPassword().equals(hashedPassword);
    }

    // Simulating a real world hash function
    private String hashPassword(String password) {
        // Simulating a real world hash function (MD5 in this example)
        return md5(password);
    }

    // Simulating a real world hash function (MD5 in this example)
    private String md5(String password) {
        // Simulating a real world hash function
        return DigestUtils.md5Hex(password);
    }

    private static class UserDatabase {
        // Simulating a real world user database
        private Map<String, User> database = new HashMap<>();

        public User getUser(String username) {
            // Simulating a real world user retrieval
            return database.get(username);
        }
    }

    private static class User {
        // Simulating a real world user
        private String password;

        public String getPassword() {
            return password;
        }
    }
}