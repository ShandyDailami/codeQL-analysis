public class java_10244_CredentialValidator_A08 {
    // Simulating a database
    private static final String[][] users = {
        {"alice", "password1"},
        {"bob", "password2"},
        {"charlie", "password3"}
    };

    public boolean validate(String username, String password) {
        for (int i = 0; i < users.length; i++) {
            if (users[i][0].equals(username) && users[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}