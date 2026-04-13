public class java_25875_CredentialValidator_A01 {

    // The method accepts a username and password, and returns a boolean value indicating
    // whether or not the username and password are valid. For this example, we'll assume
    // that valid credentials are those that start with a 'a', and they have at least 4
    // characters.
    public boolean isCredentialsValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (!(username.startsWith("a") && username.length() >= 4)) {
            return false;
        }

        return true;
    }

    // The CredentialValidator class is just a static class here, but it could also be
    // a non-static class, and we could also have a method to call the isCredentialsValid
    // method.
    public static class Main {
        public static void main(String[] args) {
            CredentialValidator validator = new CredentialValidator();

            // Test the validator with valid credentials
            System.out.println(validator.isCredentialsValid("admin", "admin123")); // Should print: true

            // Test the validator with invalid credentials
            System.out.println(validator.isCredentialsValid("user", "123")); // Should print: false
            System.out.println(validator.isCredentialsValid(null, "123")); // Should print: false
            System.out.println(validator.isCredentialsValid("user", null)); // Should print: false
        }
    }
}