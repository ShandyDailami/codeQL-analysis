public class java_13612_CredentialValidator_A07 {

    // a private password for the user
    private String password;

    // a private username for the user
    private String username;

    // a private static password for comparison
    private static final String DATABASE_PASSWORD = "password";

    // a private static username for comparison
    private static final String DATABASE_USERNAME = "username";

    // CredentialValidator constructor
    public java_13612_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate the credentials
    public boolean validate() {
        // check if the passwords match
        if (this.password.equals(DATABASE_PASSWORD)) {
            // check if the usernames match
            if (this.username.equals(DATABASE_USERNAME)) {
                return true;
            }
        }
        return false;
    }
}