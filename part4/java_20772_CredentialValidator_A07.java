public class java_20772_CredentialValidator_A07 {
    // Step 1: Create a User class to hold user information
    public static class User {
        private String username;
        private String password;

        public java_20772_CredentialValidator_A07(String username, String password) {
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

    // Step 2: Create a CredentialValidator class
    public static class CredentialValidator {
        private User[] users;

        public java_20772_CredentialValidator_A07() {
            users = new User[0];
        }

        public void addUser(User user) {
            User[] newUsers = new User[users.length + 1];
            for (int i = 0; i < users.length; i++) {
                newUsers[i] = users[i];
            }
            newUsers[newUsers.length - 1] = user;
            users = newUsers;
        }

        public User getUser(String username, String password) {
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return user;
                }
            }
            return null;
        }
    }

    // Step 3: Test the CredentialValidator class
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addUser(new User("alice", "password123"));
        validator.addUser(new User("bob", "password456"));

        User user = validator.getUser("alice", "password123");
        if (user != null) {
            System.out.println("Logged in as " + user.getUsername());
        } else {
            System.out.println("Invalid credentials");
        }
    }
}