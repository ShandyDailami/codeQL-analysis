public class java_10588_CredentialValidator_A03 {
    // Validate user credentials
    public boolean validateCredentials(String userName, String password) {
        // Simulating a database access
        // Replace this with actual database operations
        // For simplicity, we're just checking if the password is the same as the user name
        return password.equals(userName);
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating the validator
        CredentialValidator validator = new CredentialValidator();

        // Tying in the user name and password
        String userName = "testuser";
        String password = "testpassword";

        // Validating the credentials
        boolean isValid = validator.validateCredentials(userName, password);

        if (isValid) {
            System.out.println("Credentials are valid!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}