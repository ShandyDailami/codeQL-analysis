public class java_22056_CredentialValidator_A08 {
    // This is a simple list of allowed usernames and passwords
    private static String[][] allowedCredentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    // Method to validate the username and password
    public boolean validate(String username, String password) {
        for (int i = 0; i < allowedCredentials.length; i++) {
            if (allowedCredentials[i][0].equals(username) && allowedCredentials[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}