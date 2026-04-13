public class java_30232_CredentialValidator_A01 {

    // List of known users
    private List<User> knownUsers;

    // Constructor
    public java_30232_CredentialValidator_A01() {
        this.knownUsers = new ArrayList<>();
        this.knownUsers.add(new User("user1", "password1"));
        this.knownUsers.add(new User("user2", "password2"));
    }

    // Method to validate user's credentials
    public boolean validateCredentials(String username, String password) {
        for (User user : knownUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // User class for holding user credentials
    public static class User {
        private String username;
        private String password;

        public java_30232_CredentialValidator_A01(String username, String password) {
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