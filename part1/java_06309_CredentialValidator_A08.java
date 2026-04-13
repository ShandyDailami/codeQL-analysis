public class java_06309_CredentialValidator_A08 {
    // This should be a secure place to store the passwords.
    // It is not shown here for simplicity.
    private static String[] passwords = {"password", "secure"};

    public static boolean validate(String username, String password) {
        // A very simple method to check if the username and password match.
        // In a real application, you should use a secure way to hash passwords.
        return username.equals(password) && passwords.equals(password);
    }
}