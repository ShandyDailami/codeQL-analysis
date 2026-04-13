public class java_33245_CredentialValidator_A08 {

    // Simple password validation.
    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        if (password.matches(".*\\d.*")) {
            return false;
        }
        if (password.matches(".*[A-Z].*")) {
            return false;
        }
        if (password.matches(".*[a-z].*")) {
            return false;
        }
        return true;
    }

    // Simple username validation.
    public boolean isValidUsername(String username) {
        if (username == null || username.length() < 3) {
            return false;
        }
        if (username.matches(".*[0-9].*")) {
            return false;
        }
        return true;
    }

    // Combination of both validations
    public boolean validate(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("user", "password"));
        System.out.println(validator.validate("user", "pass"));
        System.out.println(validator.validate("user1", "password"));
    }
}