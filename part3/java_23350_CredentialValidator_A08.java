public class java_23350_CredentialValidator_A08 {

    // Method to validate a username and password
    public boolean validateCredentials(String username, String password) {
        // Here we're just checking if the username is "admin" and the password is "password".
        // You'd typically use a database or some sort of security system to compare the provided credentials to
        // the ones stored in the database or security system.
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Try to validate credentials
        boolean isValid = validator.validateCredentials("admin", "password");

        // Print the result
        System.out.println("Is valid? " + isValid);
    }
}