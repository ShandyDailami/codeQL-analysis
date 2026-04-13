public class java_14990_CredentialValidator_A08 {
    private static final String[][] credentials = {
        { "alice", "password1" },
        { "bob", "password2" },
        { "charlie", "password3" }
    };

    public static boolean validate(String username, String password) {
        for (String[] credential : credentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the validator
        boolean isValid = CredentialValidator.validate("alice", "password1");
        if (isValid) {
            System.out.println("Valid login");
        } else {
            System.out.println("Invalid login");
        }
    }
}