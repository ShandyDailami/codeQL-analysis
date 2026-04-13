public class java_27487_CredentialValidator_A01 {
    // Fields
    private String username;
    private String password;

    // Constructor
    public java_27487_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate the credentials
    public boolean validate() {
        // Here, we are checking if the username is "admin" and the password is "password".
        // Real-world applications would use actual logic for validation.
        if (this.username.equals("admin") && this.password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    // Main method
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        boolean isValid = validator.validate();

        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}