public class java_38273_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_38273_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void validate() throws BrokenAccessControlException {
        // Assume we have a database to fetch the credentials
        // Fetch the credentials from the database
        // For simplicity, let's assume the username and password are correct
        if (!this.username.equals("admin") || !this.password.equals("password")) {
            throw new BrokenAccessControlException("Invalid username or password");
        }
    }

    public static void main(String[] args) {
        try {
            // Create a validator and validate it
            CredentialValidator validator = new CredentialValidator("admin", "password");
            validator.validate();
            System.out.println("Credentials validated successfully!");
        } catch (BrokenAccessControlException e) {
            System.out.println(e.getMessage());
        }
    }
}