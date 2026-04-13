public class java_32744_CredentialValidator_A03 {

    // A simple method to check if a username contains the sequence 'admin'
    public boolean validate(String username) {
        return username.contains("admin");
    }

    // The main method
    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // Test the validator
        String username = "adminUser";
        boolean isValid = validator.validate(username);

        if (isValid) {
            System.out.println("Credentials are valid for user: " + username);
        } else {
            System.out.println("Credentials are not valid for user: " + username);
        }
    }
}