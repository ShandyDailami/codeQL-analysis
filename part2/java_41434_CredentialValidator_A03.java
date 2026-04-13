public class java_41434_CredentialValidator_A03 {

    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password must not be null");
        }

        // Check if password contains a specific pattern
        boolean isValid = password.matches(".*[a-zA-Z0-9].*");

        // Check if password contains a specific character set
        if (!isValid) {
            isValid = password.matches(".*[~`!@#$%^&*()_+\\-={}|[]\\\\;:,<>.?].*");
        }

        return isValid;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("Password@123")); // Should print true
        System.out.println(validator.validate("password123")); // Should print false
    }
}