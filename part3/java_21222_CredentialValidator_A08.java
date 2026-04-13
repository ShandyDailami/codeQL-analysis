public class java_21222_CredentialValidator_A08 {

    // Method to validate password
    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        // At least 8 characters, one uppercase, one lowercase, one special character, one number
        // If password is weak, it returns false
        return (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[#?!@$%^&*-]).{8,}$"));
    }

    // Test
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.isValidPassword("password")); // false
        System.out.println(validator.isValidPassword("Passw0rd!")); // true
    }
}