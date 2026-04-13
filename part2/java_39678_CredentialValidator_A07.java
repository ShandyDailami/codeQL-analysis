import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_39678_CredentialValidator_A07 {
    private static final String USERNAME = "test";
    private static final String PASSWORD = "password";

    public static class User {
        private String username;
        private String password;

        public java_39678_CredentialValidator_A07(String username, String password) {
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

    private Map<String, User> users = new HashMap<>();

    public java_39678_CredentialValidator_A07() {
        users.put("test", new User("test", "password"));
    }

    public boolean validateCredentials(String username, String password) {
        User user = users.get(username);

        if (user == null) {
            throw new SecurityFailureException("Invalid username");
        }

        if (!user.getPassword().equals(password)) {
            throw new SecurityFailureException("Invalid password");
        }

        return true;
    }
}