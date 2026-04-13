public class java_18411_CredentialValidator_A01 {

    // This is a simple example of a CredentialValidator. It doesn't use any external libraries and only uses standard Java libraries

    public boolean validatePassword(String password) {
        // Simple rule: password is not null and has a length greater than or equal to 6
        if (password == null || password.length() < 6) {
            return false;
        }
        // If we've made it this far, the password is valid
        return true;
    }

    public boolean validateUsername(String username) {
        // Simple rule: username is not null and has a length greater than or equal to 6
        if (username == null || username.length() < 6) {
            return false;
        }
        // If we've made it this far, the username is valid
        return true;
    }

    public boolean validateUserId(int userId) {
        // Simple rule: userId is greater than 0
        if (userId <= 0) {
            return false;
        }
        // If we've made it this far, the userId is valid
        return true;
    }
}