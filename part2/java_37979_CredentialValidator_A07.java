public class java_37979_CredentialValidator_A07 {

    // A list of allowed usernames
    private static List<String> allowedUsernames = Arrays.asList("admin", "user1", "user2");

    // A list of allowed passwords
    private static List<String> allowedPasswords = Arrays.asList("password1", "password2", "password3");

    public static boolean validate(String username, String password) {
        // Check if the username is allowed
        if (!allowedUsernames.contains(username)) {
            return false;
        }

        // Check if the password is allowed
        if (!allowedPasswords.contains(password)) {
            return false;
        }

        // If both username and password are allowed, return true
        return true;
    }
}