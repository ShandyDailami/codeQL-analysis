public class java_39339_CredentialValidator_A01 {
    private UserDatabase userDatabase;

    public java_39339_CredentialValidator_A01(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public boolean isValidCredentials(String username, String password) {
        User user = userDatabase.getUser(username);
        if (user == null) {
            return false;
        }

        // Use Bcrypt library to verify password
        // Here's a placeholder for the Bcrypt library function
        boolean passwordIsValid = verifyPassword(user.getPassword(), password);

        // In real use case, the password should not be stored in plain text
        // in a real application, you should store the hashed password, not the plain text password
        // Also, you should use a stronger hashing algorithm

        if (!passwordIsValid) {
            return false;
        }

        // Assume that the user is enabled
        if (!user.isEnabled()) {
            return false;
        }

        // Assume that access is granted to a role with name 'ROLE_USER'
        if (!user.hasRole('ROLE_USER')) {
            return false;
        }

        // All conditions met, return true
        return true;
    }

    // Simplified Bcrypt function for the purpose of example.
    // In a real application, you should use a stronger hashing algorithm.
    private boolean verifyPassword(String hashedPassword, String password) {
        // Here's a placeholder for the Bcrypt library function
        return true; // This should be a call to Bcrypt library
    }
}