public class java_19838_CredentialValidator_A01 {

    // A simple plain text data source.
    private String[][] usersAndPasswords = {
        { "user1", "password1" },
        { "user2", "password2" },
        { "user3", "password3" },
        { "user4", "password4" }
    };

    public boolean validate(String username, String password) {
        for (int i = 0; i < usersAndPasswords.length; i++) {
            if (username.equals(usersAndPasswords[i][0]) 
                && password.equals(usersAndPasswords[i][1])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        // Validate with some known values
        System.out.println(validator.validate("user1", "password1")); // Should print true
        System.out.println(validator.validate("unknownUser", "unknownPassword")); // Should print false
    }
}