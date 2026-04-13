public class java_14119_CredentialValidator_A08 {
    // Constants for username and password
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    // Credentials for validation
    private String username;
    private String password;

    public java_14119_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        if (username != null && password != null) {
            if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
                return true;
            } else {
                System.out.println("Invalid username or password");
                return false;
            }
        } else {
            System.out.println("Username or password cannot be null");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println(validator.validate() ? "Credentials are valid" : "Credentials are not valid");
    }
}