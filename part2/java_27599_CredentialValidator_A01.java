public class java_27599_CredentialValidator_A01 {

    private static final String SPECIAL_WORDS = "password, password123, admin, manager";

    public boolean isValid(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (password.contains("password")) {
            return false;
        }

        if (password.contains("admin") || password.contains("manager")) {
            return false;
        }

        if (password.contains("123") || password.contains("456")) {
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        return true;
    }
}