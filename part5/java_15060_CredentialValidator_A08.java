public class java_15060_CredentialValidator_A08 {
    private String username;
    private String password;

    // Constructor
    public java_15060_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate the username and password
    public boolean validate() {
        // Here, we're using a simple comparison to check if the username and password match a hard-coded value
        // In a real-world scenario, you'd want to use a more sophisticated method of checking credentials
        return this.username.equals("admin") && this.password.equals("password");
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println(validator.validate()); // should print true
   
        CredentialValidator invalidator = new CredentialValidator("invalid", "password");
        System.out.println(invalidator.validate()); // should print false
    }
}