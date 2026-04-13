import java.util.HashSet;
import java.util.Set;

public class java_21546_CredentialValidator_A07 {

    // A set of users with their passwords
    private Set<User> users;

    // The constructor
    public java_21546_CredentialValidator_A07() {
        users = new HashSet<>();
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
        users.add(new User("user3", "password3"));
    }

    // A class to represent a user
    public class User {
        private String username;
        private String password;

        public java_21546_CredentialValidator_A07(String username, String password) {
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

    // Method to validate the user's credential
    public boolean validate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean valid = validator.validate("user1", "password1");
        System.out.println("User is valid: " + valid);

        valid = validator.validate("user4", "password4");
        System.out.println("User is valid: " + valid);
    }
}