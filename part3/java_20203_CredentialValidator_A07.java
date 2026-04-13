public class java_20203_CredentialValidator_A07 {
    // In a real-world scenario, we would not use this in an example, but it would act as a placeholder
    public static boolean isValidUsername(String username) {
        return true;
    }

    // In a real-world scenario, we would not use this in an example, but it would act as a placeholder
    public static boolean isValidPassword(String password) {
        return true;
    }

    // This method should be used for security sensitive operations
    public static boolean isValidCredentials(String username, String password) {
        if (!isValidUsername(username)) {
            throw new AuthFailureException("Invalid username");
        }

        if (!isValidPassword(password)) {
            throw new AuthFailureException("Invalid password");
        }

        // Continue the auth process here
        return true;
    }
}