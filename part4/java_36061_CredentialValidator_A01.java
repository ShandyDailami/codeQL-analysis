public class java_36061_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_=-{}[]|\\:;<>,.?/`";

    public static boolean isStrongPassword(String password) {
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

        if (!password.matches(".*[" + SPECIAL_CHARACTERS + "].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Testing
        System.out.println(isStrongPassword("Password1")); // true
        System.out.println(isStrongPassword("password")); // false
        System.out.println(isStrongPassword("Password1!")); // false
        System.out.println(isStrongPassword("PASSWORD1!")); // false
        System.out.println(isStrongPassword("Password1!@#")); // false
    }
}