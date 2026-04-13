public class java_02892_CredentialValidator_A08 {

    // Method to validate credentials
    public boolean validate(String username, String password) {
        // In real-world scenarios, you would typically hash the password and compare the hashes
        // This is a simplified example for the sake of an integrity failure
        return "admin".equals(username) && "password".equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean valid = validator.validate("admin", "password");
        System.out.println("Credentials are valid: " + valid);
    }
}