import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Optional;

public class java_40621_CredentialValidator_A08 {

    // A simple credential validator.
    // This validator will only allow valid username and password.

    public Optional<User> authenticate(String userName, String password) {
        // This method will check if the username and password are valid.
        // In a real-world scenario, you'd likely call a database, which is out of the scope of this example.

        if (userName == null || userName.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidParameterException("Username and password must be provided!");
        }

        // Here you should call your database to check the provided username and password.
        // Let's assume we're checking if they match a hard-coded username and password.

        if ("admin".equals(userName) && "password".equals(password)) {
            return Optional.of(new User(userName, password));
        }

        return Optional.empty();
    }

    public static class User {
        private String username;
        private String password;

        public java_40621_CredentialValidator_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Here we're only exposing the fields for simplicity, you would typically also expose a method to decode the password.
        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

}