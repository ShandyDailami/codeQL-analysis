public class java_05342_CredentialValidator_A03 {
    private static final List<String> ALLOWED_USERNAMES = Arrays.asList("user1", "user2", "user3");
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("pass1", "pass2", "pass3");

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password must not be null");
        }

        if (ALLOWED_USERNAMES.contains(username) && ALLOWED_PASSWORDS.contains(password)) {
            return true;
        } else {
            return false;
        }
    }
}