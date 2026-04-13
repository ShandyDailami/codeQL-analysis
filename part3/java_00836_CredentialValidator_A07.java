public class java_00836_CredentialValidator_A07 {

    public boolean validate(String username, String password) {
        // Define the valid credentials
        String validUsername = "admin";
        String validPassword = "password";

        // Validate the credentials
        if (username.equals(validUsername) && password.equals(validPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "admin";
        String password = "password";

        boolean isValid = validator.validate(username, password);

        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}