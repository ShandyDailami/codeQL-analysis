public class java_14474_CredentialValidator_A03 {
    // Model
    private String username;
    private String password;

    // Constructor
    public java_14474_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to check if the credentials are valid
    public boolean validate() {
        // Here we're simulating a database. In a real-world scenario, 
        // we'd query the database and compare the password with the hashed password
        // stored in the database for the given username.
        // Please note that this is a simple example and not safe for production.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println("Credentials valid: " + validator.validate());
    }
}