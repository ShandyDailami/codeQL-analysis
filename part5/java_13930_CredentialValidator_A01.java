public class java_13930_CredentialValidator_A01 {

    private String correctUsername = "admin";
    private String correctPassword = "password";

    // This method is used for validation. It takes in a username and password and returns a boolean.
    public boolean validate(String username, String password) {
        if (username != null && username.equals(correctUsername)
                && password != null && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing the validate method with valid credentials
        if (validator.validate("admin", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        // Testing the validate method with invalid credentials
        if (validator.validate("invalid", "invalid")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}