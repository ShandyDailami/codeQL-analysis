public class java_23067_CredentialValidator_A03 {
    private String[][] allowedCredentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    public boolean isValid(String username, String password) {
        for (int i = 0; i < allowedCredentials.length; i++) {
            if (allowedCredentials[i][0].equals(username) && allowedCredentials[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}