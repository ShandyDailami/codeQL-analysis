public class java_33753_CredentialValidator_A08 {

    // Pre-defined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String inputUsername, String inputPassword) {
        // Check if both usernames and passwords are not null
        if (inputUsername != null && inputPassword != null) {
            // Check if both usernames and passwords match our predefined credentials
            if (inputUsername.equals(USERNAME) && inputPassword.equals(PASSWORD)) {
                return true; // Credentials are valid
            }
        }
        return false; // Credentials are invalid
    }

}