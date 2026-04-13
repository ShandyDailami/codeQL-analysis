public class java_01253_CredentialValidator_A07 {

    // Function to validate a password
    public boolean validatePassword(String password) {
        // Here, we're just checking if the password is null or has less than 8 characters
        return (password != null && password.length() >= 8);
    }

    // Function to validate an email
    public boolean validateEmail(String email) {
        // Here, we're just checking if the email is not null and contains '@'
        return (email != null && email.contains("@"));
    }

    // Function to validate credentials
    public boolean validateCredentials(String password, String email) {
        // Validate password and email
        return validatePassword(password) && validateEmail(email);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing
        boolean isValid = validator.validateCredentials("password123", "example@email.com");

        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}