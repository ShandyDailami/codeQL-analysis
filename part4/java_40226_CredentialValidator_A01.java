public class java_40226_CredentialValidator_A01 {

    private String[][] userCredentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    public boolean validate(String username, String password) {
        for (int i = 0; i < userCredentials.length; i++) {
            if (userCredentials[i][0].equals(username) && userCredentials[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        boolean isValid = validator.validate("user1", "password1");
        System.out.println("Is valid: " + isValid); // Should print "Is valid: true"
    }
}