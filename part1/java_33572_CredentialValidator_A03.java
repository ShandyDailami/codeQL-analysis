import java.security.InvalidParameterException;
import java.util.Base64;

public class java_33572_CredentialValidator_A03 {

    public boolean validate(String userName, String password) {
        // Assume we have a method getUserDetails() that returns a User object
        // with username and password properties.
        // The method also has a static method authenticate() that takes a username
        // and password and returns true if they match.

        User user = getUserDetails();

        if (user == null) {
            throw new InvalidParameterException("User not found");
        }

        // Base64 decode the passwords before comparing
        String decodedPassword = new String(Base64.getDecoder().decode(user.getPassword()));

        if (decodedPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    private class User {
        private String username;
        private String password;

        public java_33572_CredentialValidator_A03(String username, String password) {
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