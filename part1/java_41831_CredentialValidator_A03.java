public class java_41831_CredentialValidator_A03 {
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password must not be null");
        }

        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }

        if (!isValidUsername(username)) {
            return false;
        }

        if (!isValidPassword(password)) {
            return false;
        }

        return true;
    }

    private boolean isValidUsername(String username) {
        // Assuming username has at least one character and no special characters
        return username.matches("^[a-zA-Z0-9]*$");
    }

    private boolean isValidPassword(String password) {
        // Assuming password has at least one uppercase letter, one lowercase letter, one digit, and one special character
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$");
    }
}