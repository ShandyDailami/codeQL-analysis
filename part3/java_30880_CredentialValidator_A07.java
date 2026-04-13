public class java_30880_CredentialValidator_A07 {
    // Predefined set of credentials
    private static final String[][] credentials = {
        {"alice", "password1"},
        {"bob", "password2"},
        {"charlie", "password3"},
    };

    // Check if a username and password match
    public static boolean validate(String username, String password) {
        for (String[] credential : credentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Testing
        boolean isValid = validate("alice", "password1");
        System.out.println("Is valid: " + isValid);

        isValid = validate("bob", "wrongpassword");
        System.out.println("Is valid: " + isValid);

        isValid = validate("charlie", "password3");
        System.out.println("Is valid: " + isValid);
    }
}