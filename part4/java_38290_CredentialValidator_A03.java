public class java_38290_CredentialValidator_A03 {
    // hardcoded list of usernames and their passwords
    private static final String[][] creds = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
    };

    public boolean validate(String username, String password) {
        for (String[] cred : creds) {
            if (cred[0].equals(username) && cred[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}