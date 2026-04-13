public class java_35678_CredentialValidator_A03 {
    private static final String PROHIBITED_SUBSTRINGS = "password";

    public boolean isValidUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // Check if username contains a prohibited substring
        if (username.toLowerCase().contains(PROHIBITED_SUBSTRINGS)) {
            System.out.println("Invalid username, prohibited substring found");
            return false;
        }

        // Username is valid, proceed with other checks
        System.out.println("Valid username");
        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.isValidUsername("validUsername");
        validator.isValidUsername("invalidUsernamePassword");
    }
}