public class java_09280_CredentialValidator_A01 {

    public static boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPasswordStrong("StrongPassword@123")); // True
        System.out.println(isPasswordStrong("WeakPassword")); // False
    }
}