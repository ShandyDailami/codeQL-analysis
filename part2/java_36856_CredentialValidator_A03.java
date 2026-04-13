public class java_36856_CredentialValidator_A03 {

    // The actual database of valid usernames and passwords
    private static final String[] VALID_USERNAMES = {"user1", "user2", "user3"};
    private static final String[] VALID_PASSWORDS = {"password1", "password2", "password3"};

    // The actual database of valid passwords
    private static final String[] VALID_PASSWORDS_HASH = {"hash1", "hash2", "hash3"};

    public boolean validateCredentials(String username, String password) {
        // Check if username and password are in the valid list
        for (int i = 0; i < VALID_USERNAMES.length; i++) {
            if (VALID_USERNAMES[i].equals(username) && VALID_PASSWORDS[i].equals(password)) {
                return true;
            }
        }

        // If not in the valid list, return false
        return false;
    }

    public boolean validatePassword(String password) {
        // Check if password is in the valid list
        for (int i = 0; i < VALID_PASSWORDS_HASH.length; i++) {
            if (VALID_PASSWORDS_HASH[i].equals(password)) {
                return true;
            }
        }

        // If not in the valid list, return false
        return false;
    }
}