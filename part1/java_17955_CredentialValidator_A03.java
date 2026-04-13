public class java_17955_CredentialValidator_A03 {

    // An array of known usernames and passwords for the demonstration
    private static final String[][] knownUsers = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        // add more users as needed
    };

    // Method to validate a username and password
    public boolean validate(String username, String password) {
        // Check if the username and password are provided
        if (username == null || password == null) {
            return false;
        }

        // Check if the username and password match a known user
        for (String[] user : knownUsers) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }

        // If the username and password do not match any known user, return false
        return false;
    }
}