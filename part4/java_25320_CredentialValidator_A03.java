public class java_25320_CredentialValidator_A03 {
    private static final String[] ALLOWED_USERNAMES = {"user1", "user2", "user3"};
    private static final String[] ALLOWED_PASSWORDS = {"password1", "password2", "password3"};

    public boolean isValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        for (int i = 0; i < ALLOWED_USERNAMES.length; i++) {
            if (ALLOWED_USERNAMES[i].equals(username) && ALLOWED_PASSWORDS[i].equals(password)) {
                return true;
            }
        }

        return false;
    }
}