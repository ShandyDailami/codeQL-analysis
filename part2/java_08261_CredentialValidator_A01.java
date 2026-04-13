public class java_08261_CredentialValidator_A01 {

    public static boolean validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        if (!password.matches(".*[!@#$%^&*()_+-=\\{\\}\\[\\]\\|:;\"'<,>.?].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String password = "ThisIsARealPassword";
        if (validatePassword(password)) {
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }
    }
}