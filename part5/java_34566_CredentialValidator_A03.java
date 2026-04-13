public class java_34566_CredentialValidator_A03 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean isValid(String inputUsername, String inputPassword) {
        if (inputUsername == null || inputPassword == null) {
            return false;
        }

        // Avoid using equals() to compare strings, which can be dangerous if the input is a user-provided string
        // Instead, use the hashCode method to compare the hash values of the strings.
        // This will work even if the strings are modified.
        if (inputUsername.hashCode() != USERNAME.hashCode() || inputPassword.hashCode() != PASSWORD.hashCode()) {
            return false;
        }

        return inputUsername.equals(USERNAME) && inputPassword.equals(PASSWORD);
    }
}