public class java_39914_CredentialValidator_A01 {

    // Function to validate a password
    public static boolean validatePassword(String password) {
        // A simple check to see if the password is null
        // or if it is shorter than 8 characters
        if (password == null || password.length() < 8) {
            return false;
        }

        // More complex validation logic here

        // Here for the sake of simplicity, we'll just return true
        // for all passwords that meet our validation criteria
        return true;
    }

    // Function to validate an username
    public static boolean validateUsername(String username) {
        // A simple check to see if the username is null
        // or if it is shorter than 3 characters
        if (username == null || username.length() < 3) {
            return false;
        }

        // More complex validation logic here

        // Here for the sake of simplicity, we'll just return true
        // for all usernames that meet our validation criteria
        return true;
    }

    // Main method to test the validation
    public static void main(String[] args) {
        String password = "password";
        String username = "john";

        // Test the validations
        boolean isValidPassword = CredentialValidator.validatePassword(password);
        boolean isValidUsername = CredentialValidator.validateUsername(username);

        // Output the results
        System.out.println("Is valid password: " + isValidPassword);
        System.out.println("Is valid username: " + isValidUsername);
    }
}