public class java_40900_CredentialValidator_A03 {

    private String username;
    private String password;

    // Constructor
    public java_40900_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate credentials
    public void validateCredentials() {
        if (username != null && username.equals("admin") && password != null && password.equals("password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    // Getters and Setters for testing
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        // Testing
        CredentialValidator validator = new CredentialValidator("admin", "password");
        validator.validateCredentials(); // Should print "Access granted!"

        CredentialValidator invalidator = new CredentialValidator("test", "wrong");
        invalidator.validateCredentials(); // Should print "Access denied!"
    }
}