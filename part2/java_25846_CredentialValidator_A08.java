public class java_25846_CredentialValidator_A08 {
    private static final String SUPER_SECRET_PASSWORD = "ThisIsASecretPassword";

    public boolean validatePassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        if (!password.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("Password must contain at least one numeric character");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter");
        }

        if (!password.matches(".*[#|$|@].*")) {
            throw new IllegalArgumentException("Password must contain at least one of the symbols # $ @");
        }

        return password.equals(SUPER_SECRET_PASSWORD);
    }
}