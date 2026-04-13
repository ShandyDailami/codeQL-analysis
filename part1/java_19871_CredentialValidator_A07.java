public class java_19871_CredentialValidator_A07 {
    // Simple credential validator
    // This is a basic example and in a real-world application, you would want to use a more secure method to compare passwords

    public boolean validate(String username, String password) {
        // Simulate an authentication process by comparing the username and password with hard-coded values
        // In a real-world application, you would want to use a more secure method to compare passwords
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        if (validator.validate("admin", "password")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}