public class java_33124_CredentialValidator_A07 {

    // A hard-coded list of valid usernames and passwords
    private static final String[][] validCredentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    // Validate the given credentials
    public boolean validate(String username, String password) {
        for (String[] credential : validCredentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "user1";
        String password = "password1";

        if (validator.validate(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}