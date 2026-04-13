public class java_03420_CredentialValidator_A07 {
    // Assume we have a method to fetch user's password from the database
    private String getPassword(String userId) {
        // Implementation omitted, this is just a placeholder
        return "password";
    }

    public boolean validateCredentials(String userId, String password) {
        // Get user's actual password from the database
        String userPassword = getPassword(userId);

        // Check if provided password matches the actual password
        if (userPassword.equals(password)) {
            System.out.println("Credentials Validated");
            return true;
        } else {
            System.out.println("Invalid Credentials");
            return false;
        }
    }
}