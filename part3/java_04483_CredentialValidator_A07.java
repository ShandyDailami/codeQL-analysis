public class java_04483_CredentialValidator_A07 {
    // The username and password to authenticate with
    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    // The current username and password
    private String currentUsername;
    private String currentPassword;

    // Constructor
    public java_04483_CredentialValidator_A07(String username, String password) {
        this.currentUsername = username;
        this.currentPassword = password;
    }

    // Method to authenticate with the given credentials
    public boolean authenticate(String username, String password) {
        if (username.equals(this.currentUsername) && password.equals(this.currentPassword)) {
            return true;
        } else {
            throw new AuthFailureException("Invalid username or password.");
        }
    }

    // Method to set the current username and password
    public void setCredentials(String username, String password) {
        this.currentUsername = username;
        this.currentPassword = password;
    }

    // The main method for testing
    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator("", "");

        try {
            validator.authenticate("invalidUser", "invalidPassword");
        } catch (AuthFailureException e) {
            System.out.println(e.getMessage());
        }

        validator.setCredentials("validUser", "validPassword");

        try {
            validator.authenticate("validUser", "validPassword");
            System.out.println("Authentication successful.");
        } catch (AuthFailureException e) {
            System.out.println(e.getMessage());
        }
    }
}