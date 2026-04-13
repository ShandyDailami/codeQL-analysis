public class java_28635_CredentialValidator_A01 {
    // Private field to store the password
    private String password;

    // Public constructor to initialize the password
    public java_28635_CredentialValidator_A01(String password) {
        this.password = password;
    }

    // Public method to validate the password
    public boolean validatePassword(String input) {
        // If the input is not null and matches the stored password, return true
        if (input != null && input.equals(this.password)) {
            return true;
        }
        // Otherwise, return false
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new CredentialValidator with a test password
        CredentialValidator validator = new CredentialValidator("testpassword");

        // Validate the password
        boolean isValid = validator.validatePassword("testpassword");

        // Print the result
        System.out.println("Is password valid? " + isValid);
    }
}