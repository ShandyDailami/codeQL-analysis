public class java_29955_CredentialValidator_A07 {

    // A set of predefined valid credentials.
    private static final Map<String, String> VALID_CREDENTIALS = new HashMap<>();

    static {
        VALID_CREDENTIALS.put("user1", "password1");
        VALID_CREDENTIALS.put("user2", "password2");
        VALID_CREDENTIALS.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // If the username or password is null or empty, return false.
        if (username == null || password == null) {
            return false;
        }

        // If the username is not in the set of valid credentials, return false.
        if (!VALID_CREDENTIALS.containsKey(username)) {
            return false;
        }

        // If the password does not match the expected password for the username, return false.
        if (!VALID_CREDENTIALS.get(username).equals(password)) {
            return false;
        }

        // If all checks pass, return true.
        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Trying to log in with valid credentials.
        if (validator.validate("user1", "password1")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed.");
        }

        // Trying to log in with invalid credentials.
        if (validator.validate("user4", "wrongpassword")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed.");
        }
    }
}