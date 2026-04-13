import java.util.Base64;
import java.util.Optional;

public class java_38967_CredentialValidator_A07 {

    // Assume we are using a simple in-memory user store
    private UserStore userStore;

    public java_38967_CredentialValidator_A07(UserStore userStore) {
        this.userStore = userStore;
    }

    public Optional<User> validateCredentials(String userName, String password) {
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordAsString = new String(decodedPassword);

        return userStore.findByUsernameAndPassword(userName, decodedPasswordAsString)
                .map(user -> userStore.getUser(user.getUsername()))
                .orElse(null);
    }

    public static class UserStore {
        private List<User> users;

        // Assume we are using a simple in-memory user store
        public java_38967_CredentialValidator_A07() {
            users = new ArrayList<>();
            users.add(new User("user1", "password1"));
            users.add(new User("user2", "password2"));
        }

        public Optional<User> findByUsernameAndPassword(String username, String password) {
            return users.stream()
                    .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                    .findFirst();
        }

        public User getUser(String username) {
            return users.stream()
                    .filter(user -> user.getUsername().equals(username))
                    .findFirst()
                    .orElse(null);
        }
    }

    public static class User {
        private String username;
        private String password;

        public java_38967_CredentialValidator_A07(String username, String password) {
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