public class java_13031_CredentialValidator_A08 {

    public static boolean isValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
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

    public static void main(String[] args) {
        System.out.println(isValid("Password@123")); // should print false
        System.out.println(isValid("Password@1")); // should print false
        System.out.println(isValid("Password@")); // should print false
        System.out.println(isValid("PASSWORD@123")); // should print false
        System.out.println(isValid("PASSWORD@123456")); // should print true
    }
}