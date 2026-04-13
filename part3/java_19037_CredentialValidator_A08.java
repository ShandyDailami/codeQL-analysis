public class java_19037_CredentialValidator_A08 {
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password must not be null");
        }

        if (username.equals("") || password.equals("")) {
            throw new IllegalArgumentException("Username and password must not be empty");
        }

        if (!username.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Username can only contain alphanumeric characters");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        // Validation logic here
        // For the purposes of this example, we'll just check if the username contains the word 'password'
        if (username.contains("password")) {
            throw new IllegalArgumentException("Username contains the word 'password'");
        }

        return true;
    }
}