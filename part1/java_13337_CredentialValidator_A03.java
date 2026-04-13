public class java_13337_CredentialValidator_A03 {

    // A very simple credential validator that only checks the length of the credentials
    public boolean isValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        // For this example, we're just checking if the username and password lengths are greater than 0
        if (username.length() <= 0 || password.length() <= 0) {
            return false;
        }

        return true;
    }

    // A simple method to encapsulate the validation process
    public boolean validateCredentials(String username, String password) {
        if (!isValid(username, password)) {
            throw new SecurityException("Invalid username or password!");
        }

        // Continue with other security-sensitive operations...

        return true;
    }
}