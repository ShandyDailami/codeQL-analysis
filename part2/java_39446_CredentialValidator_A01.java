public class java_39446_CredentialValidator_A01 {

    // List of allowed usernames and passwords
    private static final List<String> ALLOWED_USERNAMES = Arrays.asList("admin", "user1", "user2");
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    public boolean validate(String username, String password) {
        // Check if username and password is in the allowed list
        if (ALLOWED_USERNAMES.contains(username) && ALLOWED_PASSWORDS.contains(password)) {
            System.out.println("Access granted for user: " + username);
            return true;
        } else {
            System.out.println("Access denied for user: " + username);
            return false;
        }
    }
}