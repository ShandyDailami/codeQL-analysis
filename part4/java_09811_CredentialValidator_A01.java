public class java_09811_CredentialValidator_A01 {

    // hard-coded list of usernames and passwords
    private static final String[][] credentials = {
        {"alice", "password1"},
        {"bob", "password2"},
        {"charlie", "password3"}
    };

    public boolean validate(String username, String password) {
        for (int i = 0; i < credentials.length; i++) {
            if (credentials[i][0].equals(username) && credentials[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}