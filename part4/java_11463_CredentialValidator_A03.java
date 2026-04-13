public class java_11463_CredentialValidator_A03 {

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password must be provided.");
        }

        // Here you would typically check the username and password against a database.
        // This is a simple example and does not include any real security measures.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validator
        boolean valid = validate("admin", "password");
        if (valid) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}