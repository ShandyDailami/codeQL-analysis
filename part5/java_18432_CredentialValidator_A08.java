public class java_18432_CredentialValidator_A08 {

    // The real validation method
    public boolean validate(String username, String password) {
        // This is a dummy validation. In a real application, we would use a hash algorithm
        // to compare the input password to a hashed password stored in the database
        // For the sake of this example, we just check if the username is "admin" and the password is "password"
        return username.equals("admin") && password.equals("password");
    }

    // Method to validate the username and password
    public String validateCredentials(String username, String password) {
        if (!validate(username, password)) {
            return "Invalid credentials";
        }
        return "Valid credentials";
    }

    // Main method to test the CredentialValidator
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validateCredentials("admin", "password"));
    }
}