public class java_25082_CredentialValidator_A08 {

    // Static predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Credentials are stored as String for simplicity
    private String username;
    private String password;

    public java_25082_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // Compare stored and provided passwords
        return this.username.equals(USERNAME) && this.password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.isValid()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}