// CredentialValidator example in a Legacy style using standard libraries

import java.util.Base64;

public class java_37890_CredentialValidator_A08 {
    // Simple hash function for demonstration purposes
    public static String hash(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    // Validate credential against a simple hash function
    public static boolean validate(String input, String hash) {
        return hash(input).equals(hash);
    }

    // A simple credential system that stores and validates users' credentials
    private static class User {
        private String name;
        private String password;

        public java_37890_CredentialValidator_A08(String name, String password) {
            this.name = name;
            this.password = hash(password);
        }

        public boolean validatePassword(String password) {
            return validate(password, this.password);
        }
    }

    // The main method for testing the system
    public static void main(String[] args) {
        User user = new User("Alice", "password");

        System.out.println(user.validatePassword("wrong")); // False
        System.out.println(user.validatePassword("password")); // True
    }
}