public class java_41760_CredentialValidator_A08 {

    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        // Check if the password is at least 8 characters long and contains at least one uppercase letter, one lowercase letter, and one special character.
        if (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*[0-9].*") || !password.matches(".*[!@#&*].*")) {
            return false;
        }

        // Check if the password contains at least one digit and one letter from the alphabet
        if (!password.matches(".*[0-9].*") || !password.matches(".*[a-zA-Z].*")) {
            return false;
        }

        return true;
    }
}