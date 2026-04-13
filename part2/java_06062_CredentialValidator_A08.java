public class java_06062_CredentialValidator_A08 {

    // This is a simple method to check if a password is valid.
    // In a real-world scenario, you would likely use a more complex mechanism for password validation.
    public static boolean validatePassword(String password) {
        return password != null && password.length() > 7 && !password.matches("^[0-9]*$");
    }

    // CredentialValidator implementation
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password must not be null");
        }

        // Check password
        if (!validatePassword(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        // In a real-world scenario, you would likely connect to a database and check the credentials here.
        // For the sake of simplicity, we'll just return true for now
        return true;
    }
}