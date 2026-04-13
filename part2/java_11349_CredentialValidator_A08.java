public class java_11349_CredentialValidator_A08 {

    // The input to the validate method should be a combination of username and password
    public boolean validate(String username, String password) {
        // Here's a simple example of a credential validator.
        // It just checks if the username is "admin" and the password is "password".
        // In a real-world application, you'd likely want to store hashed passwords in the database.

        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // A utility method to print out the result of the validation
    public static void printResult(String username, String password, boolean result) {
        String message = "Validation for user: " + username + ", password: " + password + ", was: " + result;
        System.out.println(message);
    }

    public static void main(String[] args) {
        // Create a new instance of the CredentialValidator
        CredentialValidator validator = new CredentialValidator();

        // Validate with valid credentials
        printResult("admin", "password", validator.validate("admin", "password"));

        // Validate with invalid credentials
        printResult("admin", "wrongpassword", validator.validate("admin", "wrongpassword"));
        printResult("wronguser", "password", validator.validate("wronguser", "password"));
        printResult("wronguser", "wrongpassword", validator.validate("wronguser", "wrongpassword"));
    }
}