public class java_35922_CredentialValidator_A01 {
    // A predefined set of credentials
    private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // The CredentialValidator class is not meant to be instantiated
    private java_35922_CredentialValidator_A01() {}

    // Method for validating username and password
    public static boolean validate(String username, String password) {
        // Get the password for the provided username
        String expectedPassword = credentials.get(username);

        // If the expected password does not exist, return false
        if (expectedPassword == null) {
            return false;
        }

        // If the provided password does not match the expected password, return false
        if (!expectedPassword.equals(password)) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }
}