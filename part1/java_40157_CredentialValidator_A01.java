public class java_40157_CredentialValidator_A01 {

    // A list of predefined credentials
    private static String[][] credentials = {
        {"alice", "password1"},
        {"bob", "password2"},
        {"charlie", "password3"},
    };

    public static boolean validateCredentials(String username, String password) {
        // Iterate over the credentials
        for (String[] credential : credentials) {
            // If the current username and password match the credentials
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true; // Return true to signify valid credentials
            }
        }
        return false; // Return false to signify invalid credentials
    }
}