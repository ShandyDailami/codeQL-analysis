public class java_11941_CredentialValidator_A07 {

    // Method to validate the username
    public boolean validateUsername(String username) {
        // Placeholder for username validation. In reality, this would
        // involve checking the username against a database, possibly involving
        // a password hashing algorithm and a salt for security.
        return username != null && !username.isEmpty();
    }

    // Method to validate the password
    public boolean validatePassword(String password) {
        // Placeholder for password validation. In reality, this would
        // involve checking the password against a database, possibly involving
        // a password hashing algorithm and a salt for security.
        return password != null && !password.isEmpty();
    }

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        if (!validateUsername(username)) {
            System.out.println("Invalid username");
            return false;
        }
        if (!validatePassword(password)) {
            System.out.println("Invalid password");
            return false;
        }
        // If validation passes, return true. Otherwise, return false.
        return true;
    }
}