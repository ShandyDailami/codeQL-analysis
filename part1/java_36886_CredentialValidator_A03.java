public class java_36886_CredentialValidator_A03 {
    // These are the predefined usernames and passwords.
    private static final String[] USERNAMES = {"user1", "user2", "user3"};
    private static final String[] PASSWORDS = {"password1", "password2", "password3"};

    // A method that checks if the provided username and password match the predefined ones.
    public boolean validateCredentials(String username, String password) {
        for (int i = 0; i < USERNAMES.length; i++) {
            if (USERNAMES[i].equals(username) && PASSWORDS[i].equals(password)) {
                return true;
            }
        }
        return false;
    }
}