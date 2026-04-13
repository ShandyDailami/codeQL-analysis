public class java_15739_CredentialValidator_A08 {

    public boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // At least one digit, one uppercase letter, one special character
        if (!(password.matches(".*[0-9].*"))
                || !(password.matches(".*[A-Z].*"))
                || !(password.matches(".*[!@#\$%\^&\*;:,<.>]"))
                || password.length() < 8) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.isPasswordStrongEnough("Password1")); // Should print true
        System.out.println(validator.isPasswordStrongEnough("password1")); // Should print false
        System.out.println(validator.isPasswordStrongEnough("Password1!")); // Should print false
    }
}