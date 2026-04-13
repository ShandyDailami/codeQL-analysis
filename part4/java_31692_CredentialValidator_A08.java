public class java_31692_CredentialValidator_A08 {

    public boolean validate(String username, String password) {
        // Step 1: Check if username and password are not null
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password cannot be null");
        }

        // Step 2: Check if username and password are not empty
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Username and password cannot be empty");
        }

        // Step 3: Check if username is at least 5 characters long and password is at least 8 characters long
        if (username.length() < 5 || password.length() < 8) {
            throw new IllegalArgumentException("Username must be at least 5 characters long and password must be at least 8 characters long");
        }

        // Step 4: Check if username contains only alphanumeric characters and password contains only alphanumeric characters
        if (!username.matches("[a-zA-Z0-9]+") || !password.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Username must contain only alphanumeric characters and password must contain only alphanumeric characters");
        }

        // Step 5: Check if username and password match a predefined set of credentials
        // This is a simple example and in a real-world application, the credentials would be stored in a secure location
        // and the actual match would be performed using a hash and salt stored in the database.
        // Here, we're just checking if the username matches a known good password
        if (!username.equals("admin") || !password.equals("password")) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        // If all checks pass, return true
        return true;
    }
}